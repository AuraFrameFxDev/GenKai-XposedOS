package dev.aurakai.auraframefx.oracledrive.genesis.ai

/** Minimal KaiAIService contract referenced by constructors. */
interface KaiAIService {
    suspend fun analyze(input: String): String
}

