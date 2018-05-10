package com.pinchotsoft.kpad.model

class ScratchPadConfiguration {
    val globalConfiguration: ScriptConfiguration
    val localConfiguration = ScriptConfiguration()

    init {
        globalConfiguration = ScriptConfiguration() // Actually read this in from the core location
    }
}