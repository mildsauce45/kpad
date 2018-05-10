package com.pinchotsoft.kpad.components

import com.pinchotsoft.kpad.model.ScratchPad
import javafx.scene.control.ScrollPane
import tornadofx.*

class ScratchPadEditor(val scratchPad: ScratchPad): View() {
    override val root = ScrollPane()

    init {
        val self = this

        with (root) {
            isFitToWidth = true
            isFitToHeight = true

            borderpane {
                top {
                    this += ScratchPadMenu(self)
                }
                center {
                    textarea {
                        isFitToHeight = true

                        bind(scratchPad.scriptText)
                    }
                }
            }
        }
    }
}