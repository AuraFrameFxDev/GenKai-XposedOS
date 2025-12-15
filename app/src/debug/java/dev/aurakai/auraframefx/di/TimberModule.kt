package dev.aurakai.auraframefx.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.aurakai.auraframefx.core.initialization.TimberInitializer
import dev.aurakai.auraframefx.core.initialization.TimberInitializerImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TimberModule {

    @Provides
    @Singleton
    fun provideTimberInitializer(app: Application): TimberInitializer {
        val initializer = TimberInitializerImpl()
        initializer.init(app)
        return initializer
    }
}
