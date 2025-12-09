package dev.aurakai.auraframefx.genesis.security

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultGenesisCryptographyManager @Inject constructor() : CryptographyManager {
    override fun encrypt(input: ByteArray): ByteArray = input // placeholder
    override fun decrypt(input: ByteArray): ByteArray = input // placeholder
}

