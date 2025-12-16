package dev.aurakai.auraframefx.di

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.aurakai.auraframefx.ai.clients.VertexAIClient
import dev.aurakai.auraframefx.ai.services.AuraAIService
import dev.aurakai.auraframefx.ai.services.GenesisBridgeService
import dev.aurakai.auraframefx.ai.services.KaiAIService
import dev.aurakai.auraframefx.ai.services.TrinityCoordinatorService
import dev.aurakai.auraframefx.context.ContextManager
import dev.aurakai.auraframefx.data.logging.AuraFxLogger
import dev.aurakai.auraframefx.oracledrive.genesis.ai.services.DefaultAuraAIService
import dev.aurakai.auraframefx.security.SecurityContext
import dev.aurakai.auraframefx.security.SecurityMonitor
import dev.aurakai.auraframefx.services.DefaultKaiAIService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class TrinityModule {

    @Binds
    @Singleton
    abstract fun bindAuraAIService(impl: DefaultAuraAIService): AuraAIService

    @Binds
    @Singleton
    abstract fun bindKaiAIService(impl: DefaultKaiAIService): KaiAIService

    companion object {
        @Provides
        @Singleton
        fun provideGenesisBridgeService(
            auraAIService: AuraAIService,
            kaiAIService: KaiAIService,
            vertexAIClient: VertexAIClient,
            contextManager: ContextManager,
            securityContext: SecurityContext,
            @ApplicationContext applicationContext: Context,
            logger: AuraFxLogger,
        ): GenesisBridgeService {
            return GenesisBridgeService(
                auraAIService = auraAIService,
                kaiAIService = kaiAIService,
                vertexAIClient = vertexAIClient,
                contextManager = contextManager,
                securityContext = securityContext,
                applicationContext = applicationContext,
                logger = logger
            )
        }

        @Provides
        @Singleton
        fun provideTrinityCoordinatorService(
            auraAIService: AuraAIService,
            kaiAIService: KaiAIService,
            genesisBridgeService: GenesisBridgeService,
            securityContext: SecurityContext,
            logger: AuraFxLogger,
        ): TrinityCoordinatorService {
            return TrinityCoordinatorService(
                auraAIService = auraAIService,
                kaiAIService = kaiAIService,
                genesisBridgeService = genesisBridgeService,
                securityContext = securityContext,
                logger = logger
            )
        }

        @Provides
        @Singleton
        fun provideSecurityMonitor(
            securityContext: SecurityContext,
            genesisBridgeService: GenesisBridgeService,
            logger: AuraFxLogger,
        ): SecurityMonitor {
            return SecurityMonitor(
                securityContext = securityContext,
                genesisBridgeService = genesisBridgeService,
                logger = logger
            )
        }
    }
}
