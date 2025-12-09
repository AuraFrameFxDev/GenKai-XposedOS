package dev.aurakai.auraframefx.system.impl

import android.util.Log
import dev.aurakai.auraframefx.common.ErrorHandler
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultErrorHandler @Inject constructor() : ErrorHandler {
    override fun handle(error: Throwable) {
        Log.e("DefaultErrorHandler", "Caught error", error)
    }
}

