package dev.aurakai.auraframefx.ai.agents

import dev.aurakai.auraframefx.models.AgentType
import dev.aurakai.auraframefx.models.InteractionRequest
import dev.aurakai.auraframefx.models.InteractionResponse
import kotlinx.coroutines.flow.Flow

interface Agent {
    val agentName: String
    val agentType: AgentType

    fun processRequest(request: InteractionRequest): InteractionResponse
    fun processRequestFlow(request: InteractionRequest): Flow<InteractionResponse>
}
