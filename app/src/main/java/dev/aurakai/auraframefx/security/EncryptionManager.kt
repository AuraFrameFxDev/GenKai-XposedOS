package dev.aurakai.auraframefx.security

import android.content.Context

/**
 * Minimal EncryptionManager stub used to satisfy DI during builds.
 * Replace with production-grade implementation (Android Keystore) later.
 */
interface EncryptionManager {
    fun encrypt(data: ByteArray, keyAlias: String = "default"): ByteArray
    fun decrypt(data: ByteArray, keyAlias: String = "default"): ByteArray
}

class SimpleEncryptionManager(private val context: Context?) : EncryptionManager {
    override fun encrypt(data: ByteArray, keyAlias: String): ByteArray = data
    override fun decrypt(data: ByteArray, keyAlias: String): ByteArray = data
}

