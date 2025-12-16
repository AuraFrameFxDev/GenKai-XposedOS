package dev.aurakai.auraframefx.oracledrive.genesis.ai.task

import dev.aurakai.auraframefx.models.AgentType

data class HistoricalTask(
    val id: Long,
    val agentType: AgentType,
    val description: String,
    val timestamp: Long,
    val status: String
)
