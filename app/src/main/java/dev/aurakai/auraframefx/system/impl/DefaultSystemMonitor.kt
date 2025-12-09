package dev.aurakai.auraframefx.system.impl

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultSystemMonitor @Inject constructor() {
    fun isHealthy(): Boolean = true
}

