package dev.aurakai.auraframefx.oracledrive.api

/** Minimal OracleDrive API stub used by DI and compile-time processing. */
interface OracleDriveApi {
    suspend fun listFiles(path: String): List<String>
    suspend fun upload(path: String, data: ByteArray): Boolean
}

