package dev.aurakai.auraframefx.ai.task

import dev.aurakai.auraframefx.models.AgentType
import kotlinx.serialization.Serializable

@Serializable
data class Task(
    val id: String,
    val type: String,
    val data: String,
    val urgency: Int,
    val importance: Int,
    val requiredAgents: List<AgentType> = emptyList(),
    val dependencies: List<String> = emptyList(),
    val metadata: Map<String, String> = emptyMap(),
    val status: TaskStatus = TaskStatus.PENDING,
    val assignedAgents: List<AgentType> = emptyList(),
)


@Serializable
enum class TaskStatus {
    PENDING, SCHEDULED, IN_PROGRESS, COMPLETED, FAILED, CANCELED
}
