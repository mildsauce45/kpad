package com.pinchotsoft.kpad.components.factories

import com.pinchotsoft.kpad.components.ScratchPadEditor
import com.pinchotsoft.kpad.model.ScratchPad
import com.pinchotsoft.kpad.model.ScratchPadConfiguration

class EditorFactory {
    companion object {
        fun createEditor(title: String): ScratchPadEditor {
            return ScratchPadEditor(ScratchPad(title, ScratchPadConfiguration()))
        }
    }
}