package dev.aurakai.auraframefx.ipc

import android.app.Service
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.IBinder
import android.os.RemoteCallbackList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.lang.Exception
import timber.log.Timber
import dev.aurakai.auraframefx.oracledrive.CloudStorageProvider
import dev.aurakai.auraframefx.oracledrive.OracleCloudStorageProvider

/**
 * Concrete Service that exposes the IAuraDriveService AIDL interface.
 * It delegates cloud operations to an internal CloudStorageProviderImpl.
 * This is intentionally defensive and minimal so it compiles and can be extended.
 */
class AuraDriveService : Service() {
    // NOTE: Some builds may not have the full Oracle cloud implementation available
    // at compile-time. To keep this service usable for small wins we use a lightweight
    // internal provider abstraction and a stub implementation here. If a runtime
    // implementation (CloudStorageProviderImpl) is available it can be wired in later.

    // Use the small CloudStorageProvider abstraction (local stub or real provider).
    private sealed class UploadResult {
        data class Success(val fileId: String) : UploadResult()
        data class Error(val cause: Throwable?) : UploadResult()
    }

    // Prefer an injected/real provider; default to a safe Oracle stub implementation
    // so the service remains functional when the SDK wiring isn't present.
    private val cloudProviderImpl: CloudStorageProvider by lazy {
        // TODO: Replace with real wiring (DI/Hilt) to provide a production implementation.
        OracleCloudStorageProvider(bucketName = "auradrive-default")
    }
    private val callbacks = RemoteCallbackList<IAuraDriveCallback>()

    // The binder exposed to AIDL clients
    private val binder = object : IAuraDriveService.Stub() {
        override fun getServiceVersion(): String = "1.0"

        override fun registerCallback(callback: IAuraDriveCallback?) {
            callback ?: return
            callbacks.register(callback)
        }

        override fun unregisterCallback(callback: IAuraDriveCallback?) {
            callback ?: return
            callbacks.unregister(callback)
        }

        override fun executeCommand(command: String?, params: Bundle?): String {
            // Minimal command dispatcher — extend with real commands as needed
            return when (command) {
                "ping" -> "pong"
                else -> "unsupported"
            }
        }

        override fun toggleLSPosedModule(packageName: String?, enable: Boolean): String {
            // This service doesn't manage LSPosed directly; return a neutral response
            return "not_supported"
        }

        override fun getOracleDriveStatus(): String = "OK"

        override fun getDetailedInternalStatus(): String = "AuraDriveService running"

        override fun getInternalDiagnosticsLog(): String = "No diagnostics available"

        override fun getSystemInfo(): String = "Android Service" // could be augmented

        override fun updateConfiguration(config: Bundle?): Boolean {
            // Apply configuration if needed; currently a noop
            return true
        }

        override fun subscribeToEvents(eventTypes: Int) {
            // noop — event publishing can be implemented later
        }

        override fun unsubscribeFromEvents(eventTypes: Int) {
            // noop
        }

        override fun importFile(uri: Uri?): String {
            if (uri == null) return ""
            try {
                val tmp = uriToTempFile(uri) ?: return ""
                return when (val result = runBlockingUpload(tmp)) {
                    is UploadResult.Success -> result.fileId
                    is UploadResult.Error -> ""
                }
            } catch (ex: Exception) {
                Timber.w(ex, "importFile failed")
                return ""
            }
        }

        override fun exportFile(fileId: String?, destinationUri: Uri?): Boolean {
            if (fileId.isNullOrEmpty()) return false
            // Attempt to download via cloud provider; since provider is a stub, interpret Success as OK
            return try {
                val res = runBlocking(Dispatchers.IO) {
                    // convert the CloudStorageProvider.FileResult to local UploadResult
                    when (val r = cloudProviderImpl.downloadFile(fileId)) {
                        is dev.aurakai.auraframefx.oracledrive.FileResult.Success -> UploadResult.Success(r.fileId)
                        is dev.aurakai.auraframefx.oracledrive.FileResult.Error -> UploadResult.Error(r.cause)
                        else -> UploadResult.Error(null)
                    }
                }
                when (res) {
                    is UploadResult.Success -> {
                        Timber.i("exportFile: download success for id=${res.fileId}")
                        true
                    }
                    is UploadResult.Error -> {
                        Timber.w("exportFile: download failed for id=$fileId")
                        false
                    }
                }
            } catch (ex: Exception) {
                Timber.w(ex, "exportFile failed")
                false
            }
        }

        override fun verifyFileIntegrity(fileId: String?): Boolean {
            if (fileId.isNullOrEmpty()) return false
            // Minimal integrity check: ensure the file exists in cloud provider (stub)
            return try {
                val res = runBlocking(Dispatchers.IO) {
                    when (val r = cloudProviderImpl.downloadFile(fileId)) {
                        is dev.aurakai.auraframefx.oracledrive.FileResult.Success -> UploadResult.Success(r.fileId)
                        is dev.aurakai.auraframefx.oracledrive.FileResult.Error -> UploadResult.Error(r.cause)
                        else -> UploadResult.Error(null)
                    }
                }
                res is UploadResult.Success
            } catch (ex: Exception) {
                Timber.w(ex, "verifyFileIntegrity failed")
                false
            }
        }
    }

    override fun onBind(intent: Intent?): IBinder = binder

    override fun onDestroy() {
        callbacks.kill()
        super.onDestroy()
    }

    // Helpers
    private fun uriToTempFile(uri: Uri): File? {
        try {
            val input: InputStream? = contentResolver.openInputStream(uri)
            input ?: return null
            val tmp = File.createTempFile("auradrive-import-", ".tmp", cacheDir)
            FileOutputStream(tmp).use { out ->
                input.use { inp ->
                    inp.copyTo(out)
                }
            }
            return tmp
        } catch (ex: Exception) {
            Timber.w(ex, "uriToTempFile failed")
            return null
        }
    }

    private fun runBlockingUpload(file: File): UploadResult {
        return try {
            runBlocking(Dispatchers.IO) {
                when (val r = cloudProviderImpl.uploadFile(file, emptyMap())) {
                    is dev.aurakai.auraframefx.oracledrive.FileResult.Success -> UploadResult.Success(r.fileId)
                    is dev.aurakai.auraframefx.oracledrive.FileResult.Error -> UploadResult.Error(r.cause)
                }
            }
        } catch (ex: Exception) {
            Timber.w(ex, "runBlockingUpload failed")
            UploadResult.Error(ex)
        }
    }
}
