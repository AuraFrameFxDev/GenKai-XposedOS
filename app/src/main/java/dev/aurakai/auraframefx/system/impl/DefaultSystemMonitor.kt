package dev.aurakai.auraframefx.system.impl

import javax.inject.Inject
import javax.inject.Singleton
import dev.aurakai.auraframefx.system.monitor.SystemMonitor

/**
 * Minimal DefaultSystemMonitor implementation used for DI bindings.
 */
@Singleton
class DefaultSystemMonitor @Inject constructor() : SystemMonitor {
    override fun isHealthy(): Boolean = true
}

// Keep a simple legacy alias for older modules
class SimpleSystemMonitor : DefaultSystemMonitor()
