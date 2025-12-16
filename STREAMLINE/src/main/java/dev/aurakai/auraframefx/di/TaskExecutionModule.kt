package dev.aurakai.auraframefx.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.aurakai.auraframefx.ai.task.execution.TaskExecutionManager
import dev.aurakai.auraframefx.oracledrive.genesis.ai.task.execution.GenesisTaskExecutionManager
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TaskExecutionModule {

    @Provides
    @Singleton
    fun provideTaskExecutionManager(): TaskExecutionManager {
        return TaskExecutionManager()
    }

    @Provides
    @Singleton
    fun provideGenesisTaskExecutionManager(): GenesisTaskExecutionManager {
        return GenesisTaskExecutionManager()
    }
}
