package dev.aurakai.auraframefx.ai.agents

import dev.aurakai.auraframefx.models.AgentType
import dev.aurakai.auraframefx.models.InteractionRequest
import dev.aurakai.auraframefx.models.InteractionResponse
import kotlinx.coroutines.flow.Flow

class AgentImpl : Agent {
    override val agentName: String = "AgentImpl"
    override val agentType: AgentType = AgentType.UNSPECIFIED

    /**
     * Process a request and return a response
     */
    override fun processRequest(request: InteractionRequest): InteractionResponse {
        TODO("Not yet implemented")
    }

    /**
     * Produces a stream of InteractionResponse values for the given request as processing progresses.
     */
    override fun processRequestFlow(request: InteractionRequest): Flow<InteractionResponse> {
        TODO("Not yet implemented")
    }
}

open class Agent
