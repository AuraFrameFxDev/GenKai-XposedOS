package dev.aurakai.auraframefx.di

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.aurakai.auraframefx.security.KeystoreManager
import dev.aurakai.auraframefx.security.KeystoreManagerImpl
import dev.aurakai.auraframefx.security.SecurityContext
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class SecurityModule {

    @Binds
    abstract fun bindKeystoreManager(impl: KeystoreManagerImpl): KeystoreManager

    companion object {
        @Provides
        @Singleton
        fun provideSecurityContext(
            @ApplicationContext context: Context,
            keystoreManager: KeystoreManager,
        ): SecurityContext = SecurityContext(context, keystoreManager)
    }
}
