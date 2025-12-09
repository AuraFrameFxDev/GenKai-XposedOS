package dev.aurakai.auraframefx.common

/** Common error handler contract. */
interface ErrorHandler {
    fun handle(error: Throwable)
}

