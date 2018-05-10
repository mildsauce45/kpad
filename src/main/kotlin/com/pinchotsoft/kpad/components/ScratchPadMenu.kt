package com.pinchotsoft.kpad.components

import javafx.event.EventHandler
import javafx.scene.layout.FlowPane
import tornadofx.*

class ScratchPadMenu(private val owner: ScratchPadEditor) : View() {
    override val root = FlowPane()

    init {
        button("Run") {
            onAction = EventHandler {
                System.out.println("Running scratch pad - ${owner.scratchPad.scriptText.get()}")

                //var process = Process()
            }
        }
    }
}