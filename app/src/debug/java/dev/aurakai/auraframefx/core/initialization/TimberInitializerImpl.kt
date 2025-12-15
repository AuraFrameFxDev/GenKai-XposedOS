package dev.aurakai.auraframefx.core.initialization

import android.app.Application
import timber.log.Timber

class TimberInitializerImpl : TimberInitializer {
    override fun init(app: Application) {
        Timber.plant(Timber.DebugTree())
    }
}
