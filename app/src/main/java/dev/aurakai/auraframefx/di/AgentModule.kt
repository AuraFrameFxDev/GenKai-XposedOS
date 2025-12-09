package dev.aurakai.auraframefx.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.aurakai.auraframefx.ai.context.ContextManager
import dev.aurakai.auraframefx.ai.context.DefaultContextManager
import dev.aurakai.auraframefx.ai.memory.DefaultMemoryManager
import dev.aurakai.auraframefx.ai.memory.MemoryManager
import javax.inject.Singleton

/**
 * Hilt Module for providing AI Agent dependencies.
 */
@Module
@InstallIn(SingletonComponent::class)
object AgentModule {

    @Provides
    @Singleton
    fun provideMemoryManager(): MemoryManager {
        return DefaultMemoryManager()
    }

    @Provides
    @Singleton
    fun provideContextManager(memoryManager: MemoryManager): ContextManager {
        return DefaultContextManager(memoryManager)
    }

    @Provides
    @Singleton
    fun provideAuraAgent(
        vertexAIClient: dev.aurakai.auraframefx.oracledrive.genesis.ai.VertexAIClient,
        auraAIService: dev.aurakai.auraframefx.oracledrive.genesis.ai.AuraAIService,
        securityContext: dev.aurakai.auraframefx.security.SecurityContext,
        contextManager: ContextManager
    ): dev.aurakai.auraframefx.aura.AuraAgent {
        return dev.aurakai.auraframefx.aura.AuraAgent(
            vertexAIClient = vertexAIClient,
            auraAIService = auraAIService,
            securityContext = securityContext,
            contextManager = contextManager
        )
    }

    @Provides
    @Singleton
    fun provideKaiAgent(
        vertexAIClient: dev.aurakai.auraframefx.oracledrive.genesis.ai.VertexAIClient,
        contextManager: ContextManager,
        securityContext: dev.aurakai.auraframefx.security.SecurityContext,
        systemMonitor: dev.aurakai.auraframefx.system.monitor.SystemMonitor
    ): dev.aurakai.auraframefx.kai.KaiAgent {
        return dev.aurakai.auraframefx.kai.KaiAgent(
            vertexAIClient = vertexAIClient,
            contextManager = contextManager,
            securityContext = securityContext,
            systemMonitor = systemMonitor
        )
    }
}
