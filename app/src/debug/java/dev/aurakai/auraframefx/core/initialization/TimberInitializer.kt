package dev.aurakai.auraframefx.core.initialization

import android.app.Application
import timber.log.Timber

class TimberInitializer {
    fun init(app: Application) {
        Timber.plant(Timber.DebugTree())
    }
}
