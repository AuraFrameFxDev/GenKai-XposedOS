package dev.aurakai.auraframefx.di

import dev.aurakai.auraframefx.utils.AuraFxLogger
import dev.aurakai.auraframefx.utils.LogLevel
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultAuraFxLogger @Inject constructor() : AuraFxLogger {
    override fun debug(tag: String, message: String, throwable: Throwable?) {
        Timber.d(throwable, "[$tag] $message")
    }

    override fun info(tag: String, message: String, throwable: Throwable?) {
        Timber.i(throwable, "[$tag] $message")
    }

    override fun warn(tag: String, message: String, throwable: Throwable?) {
        Timber.w(throwable, "[$tag] $message")
    }

    override fun error(tag: String, message: String, throwable: Throwable?) {
        Timber.e(throwable, "[$tag] $message")
    }

    override fun security(tag: String, message: String, throwable: Throwable?) {
        Timber.wtf(throwable, "🔒 SECURITY [$tag] $message")
    }

    override fun performance(
        tag: String,
        operation: String,
        durationMs: Long,
        metadata: Map<String, Any>
    ) {
        val metadataStr = if (metadata.isNotEmpty()) " | Metadata: $metadata" else ""
        Timber.i("⏱️ PERFORMANCE [$tag] $operation completed in ${durationMs}ms$metadataStr")
    }

    override fun userInteraction(tag: String, action: String, metadata: Map<String, Any>) {
        val metadataStr = if (metadata.isNotEmpty()) " | Metadata: $metadata" else ""
        Timber.d("👤 USER_INTERACTION [$tag] $action$metadataStr")
    }

    override fun aiOperation(
        tag: String,
        operation: String,
        confidence: Float,
        metadata: Map<String, Any>
    ) {
        val metadataStr = if (metadata.isNotEmpty()) " | Metadata: $metadata" else ""
        Timber.i("🤖 AI_OPERATION [$tag] $operation (confidence: ${String.format("%.2f", confidence)})$metadataStr")
    }

    override fun setLoggingEnabled(enabled: Boolean) {
        // Placeholder for enabling/disabling logging
    }

    override fun setLogLevel(level: LogLevel) {
        // Placeholder for setting log level
    }

    override suspend fun flush() {
        // Placeholder for flushing logs
    }

    override fun cleanup() {
        // Placeholder for cleanup
    }
}
