package dev.aurakai.auraframefx.network

import javax.inject.Inject

// Minimal wrapper around API service interfaces used by repositories
class AuraApiServiceWrapper @Inject constructor(
    val userApi: Any? = null,
    val aiAgentApi: Any? = null,
    val themeApi: Any? = null
)

