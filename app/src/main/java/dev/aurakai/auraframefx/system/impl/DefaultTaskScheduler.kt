package dev.aurakai.auraframefx.system.impl

import javax.inject.Inject

interface DefaultTaskScheduler {
    fun schedule(task: Runnable)
}

class DefaultTaskSchedulerImpl @Inject constructor(): DefaultTaskScheduler {
    override fun schedule(task: Runnable) { Thread(task).start() }
}

