package com.pinchotsoft.kpad.model

import javafx.beans.property.SimpleStringProperty

class ScratchPad(var title: String, val configuration: ScratchPadConfiguration) {
    var scriptText = SimpleStringProperty()

    init {

    }
}