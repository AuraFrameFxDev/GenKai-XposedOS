package dev.aurakai.auraframefx.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.aurakai.auraframefx.ai.memory.MemoryManager as AiMemoryManager
import dev.aurakai.auraframefx.cascade.pipeline.AIPipelineConfig
import dev.aurakai.auraframefx.di.qualifiers.AiMemory
import dev.aurakai.auraframefx.di.qualifiers.GenesisMemory
import dev.aurakai.auraframefx.oracledrive.genesis.ai.memory.DefaultMemoryManager
import dev.aurakai.auraframefx.oracledrive.genesis.ai.memory.MemoryManager as GenesisMemoryManager
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MemoryModule {

    @Provides
    @Singleton
    @AiMemory
    fun provideAiMemoryManager(config: AIPipelineConfig): AiMemoryManager {
        return AiMemoryManager(config)
    }

    @Provides
    @Singleton
    @GenesisMemory
    fun provideGenesisMemoryManager(): GenesisMemoryManager {
        return DefaultMemoryManager()
    }
}
