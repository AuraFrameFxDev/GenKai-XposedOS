package dev.aurakai.auraframefx.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// This is a placeholder for the real TimberInitializer
class TimberInitializer

@Module
@InstallIn(SingletonComponent::class)
object TimberModule {
    @Provides
    @Singleton
    fun provideTimberInitializer(): TimberInitializer = TimberInitializer()
}
