package dev.aurakai.auraframefx.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.aurakai.auraframefx.cascade.memory.AgentMemoryEntity
import dev.aurakai.auraframefx.cascade.memory.AgentMemoryDao
import dev.aurakai.auraframefx.data.room.TaskHistoryEntity
import dev.aurakai.auraframefx.data.room.TaskHistoryDao
import dev.aurakai.auraframefx.cascade.memory.AgentMemoryDao
import dev.aurakai.auraframefx.cascade.memory.AgentMemoryEntity

@Database(
    entities = [AgentMemoryEntity::class, TaskHistoryEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun agentMemoryDao(): AgentMemoryDao
    abstract fun taskHistoryDao(): TaskHistoryDao
}
