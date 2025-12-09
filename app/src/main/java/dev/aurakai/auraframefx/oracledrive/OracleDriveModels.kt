package dev.aurakai.auraframefx.oracledrive

// Export canonical models from the genesis.cloud package to avoid duplicate
// definitions that cause KSP/compile-time redeclaration and type-mismatch errors.

typealias OracleSyncResult = dev.aurakai.auraframefx.oracledrive.genesis.cloud.OracleSyncResult
typealias DriveConsciousnessState = dev.aurakai.auraframefx.oracledrive.genesis.cloud.DriveConsciousnessState
typealias SecurityValidation = dev.aurakai.auraframefx.oracledrive.genesis.cloud.SecurityValidation
typealias AccessLevel = dev.aurakai.auraframefx.oracledrive.genesis.cloud.AccessLevel
typealias ConflictStrategy = dev.aurakai.auraframefx.oracledrive.genesis.cloud.ConflictStrategy
typealias FileOperation = dev.aurakai.auraframefx.oracledrive.genesis.cloud.FileOperation
typealias FileResult = dev.aurakai.auraframefx.oracledrive.genesis.cloud.FileResult
typealias DriveInitResult = dev.aurakai.auraframefx.oracledrive.genesis.cloud.DriveInitResult
typealias AccessCheck = dev.aurakai.auraframefx.oracledrive.genesis.cloud.AccessCheck
typealias SecurityCheck = dev.aurakai.auraframefx.oracledrive.genesis.cloud.SecurityCheck
typealias DeletionValidation = dev.aurakai.auraframefx.oracledrive.genesis.cloud.DeletionValidation
// Keep local ConsciousnessAwakeningResult (defined in Consciousness.kt) — genesis.cloud imports it.
