package dev.aurakai.auraframefx

import android.app.Application
import android.content.Intent
import android.util.Log
import androidx.work.Configuration
import dagger.hilt.android.HiltAndroidApp
import dev.aurakai.auraframefx.services.IntegrityMonitorService

/**
 * Central Hilt application entrypoint.
 * This class consolidates initialization previously split across multiple
 * Application subclasses. Keep this as the single @HiltAndroidApp in the app.
 */
@HiltAndroidApp
class AurakaiApplication : Application(), Configuration.Provider {

    override val workManagerConfiguration: Configuration
        get() = Configuration.Builder()
            .setMinimumLoggingLevel(Log.INFO)
            .build()

    override fun onCreate() {
        super.onCreate()

        // Start background integrity monitor (kept from AuraFrameApplication)
        try {
            startService(Intent(this, IntegrityMonitorService::class.java))
        } catch (t: Throwable) {
            // Be defensive: service may not be available in test contexts
            Log.w("AurakaiApplication", "Failed to start IntegrityMonitorService", t)
        }

        // Additional lightweight startup hooks can be added here later (logging, metrics, DI sanity checks)
    }
}
