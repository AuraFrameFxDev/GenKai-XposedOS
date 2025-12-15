package dev.aurakai.auraframefx.core.initialization

import android.app.Application

interface TimberInitializer {
    fun init(app: Application)
    fun logHealthMetric(string: String, eventJson: String) {
        TODO("Not yet implemented")
    }
}
