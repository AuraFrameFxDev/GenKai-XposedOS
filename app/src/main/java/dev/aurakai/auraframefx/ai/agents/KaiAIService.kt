package dev.aurakai.auraframefx.ai.agents

/**
 * Minimal KaiAIService stub for DI. The real implementation provides security/monitoring services.
 */
interface KaiAIService {
    suspend fun start(): Boolean
}

class NoOpKaiAIService : KaiAIService {
    override suspend fun start(): Boolean = true
}

