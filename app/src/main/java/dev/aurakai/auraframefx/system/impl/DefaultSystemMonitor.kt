package dev.aurakai.auraframefx.system.impl

import android.content.Context
import javax.inject.Inject
import javax.inject.Singleton
import dev.aurakai.auraframefx.system.monitor.SystemMonitor
import dev.aurakai.auraframefx.utils.AuraFxLogger

/**
 * Minimal DefaultSystemMonitor implementation used for DI bindings.
 * Now properly subclasses the open SystemMonitor and injects required dependencies.
 */
@Singleton
class DefaultSystemMonitor @Inject constructor(
    context: Context,
    logger: AuraFxLogger,
) : SystemMonitor(context, logger) {
    // Intentionally minimal; SystemMonitor contains behavior.
}

// Keep a simple legacy alias for older modules
class SimpleSystemMonitor @Inject constructor(
    context: Context,
    logger: AuraFxLogger,
) : DefaultSystemMonitor(context, logger)
