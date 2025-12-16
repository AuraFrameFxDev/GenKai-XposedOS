package dev.aurakai.auraframefx.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.aurakai.auraframefx.utils.AuraFxLogger
import dev.aurakai.auraframefx.utils.DefaultAuraFxLogger
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LoggerModule {

    @Binds
    @Singleton
    abstract fun bindAuraFxLogger(defaultAuraFxLogger: DefaultAuraFxLogger): AuraFxLogger
}
