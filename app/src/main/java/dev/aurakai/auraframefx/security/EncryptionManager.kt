package dev.aurakai.auraframefx.security

import android.content.Context

/**
 * Minimal EncryptionManager stub for DI and compilation.
 * Replace with real implementation using AndroidX Security or Keystore.
 */
interface EncryptionManager {
    fun encrypt(data: ByteArray, alias: String = "default"): ByteArray
    fun decrypt(data: ByteArray, alias: String = "default"): ByteArray
}

class NoOpEncryptionManager(private val context: Context?) : EncryptionManager {
    override fun encrypt(data: ByteArray, alias: String): ByteArray = data
    override fun decrypt(data: ByteArray, alias: String): ByteArray = data
}

