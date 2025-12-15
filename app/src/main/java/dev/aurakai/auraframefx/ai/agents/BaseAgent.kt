package dev.aurakai.auraframefx.ai.agents

import dev.aurakai.auraframefx.models.InteractionRequest
import dev.aurakai.auraframefx.models.InteractionResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

abstract class BaseAgent : Agent {
    override fun processRequest(request: InteractionRequest): InteractionResponse {
        // Default implementation
        return InteractionResponse(
            content = "Request received, but not processed by ${agentName}.",
            agent = agentType
        )
    }

    override fun processRequestFlow(request: InteractionRequest): Flow<InteractionResponse> = flow {
        emit(processRequest(request))
    }
}
