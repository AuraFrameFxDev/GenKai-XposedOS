package dev.aurakai.auraframefx.security

import javax.crypto.Cipher
import javax.crypto.SecretKey

interface KeystoreManager {
    fun getOrCreateSecretKey(): SecretKey?
    fun getDecryptionCipher(iv: ByteArray): Cipher?
}
