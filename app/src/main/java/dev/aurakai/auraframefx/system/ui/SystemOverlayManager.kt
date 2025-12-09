package dev.aurakai.auraframefx.system.ui

import dev.aurakai.auraframefx.system.overlay.OverlayAnimation
import dev.aurakai.auraframefx.system.overlay.OverlayElement
import dev.aurakai.auraframefx.system.overlay.OverlayShape
import dev.aurakai.auraframefx.system.overlay.OverlayTheme
import dev.aurakai.auraframefx.system.overlay.OverlayTransition
import dev.aurakai.auraframefx.system.overlay.SystemOverlayConfig

interface SystemOverlayManager {
    fun applyTheme(theme: OverlayTheme)
    fun applyElement(element: OverlayElement)
    fun applyAnimation(animation: OverlayAnimation)
    fun applyTransition(transition: OverlayTransition)
    fun applyShape(shape: OverlayShape)
    fun applyConfig(config: SystemOverlayConfig)
    fun removeElement(elementId: String)
    fun clearAll()
}
