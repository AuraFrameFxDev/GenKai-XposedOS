package dev.aurakai.auraframefx.ai.agents

/**
 * Minimal KaiAIService marker interface to satisfy DI and KSP when the real implementation is absent.
 * The real Kai agent implementation should provide advanced capabilities.
 */
interface KaiAIService {
    suspend fun respondTo(prompt: String): String
}

class StubKaiAIService : KaiAIService {
    override suspend fun respondTo(prompt: String): String = "[Kai stub response]"
}

