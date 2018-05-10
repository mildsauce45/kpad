package com.pinchotsoft.kpad.components

import javafx.scene.layout.GridPane
import tornadofx.*

class MainWindow : View("KPad") {
    override val root = GridPane()
    private val mainMenu: MainMenu by inject()
    private val scratchPadPane: ScratchPadPane by inject()

    init {
        setWindowMinSize(640.0, 480.0)

        with (root) {
            prefWidth = 1024.0
            prefHeight = 724.0

            constraintsForColumn(0).percentWidth = 100.0

            row {
                this += mainMenu
            }

            row {
                this += scratchPadPane
            }

            constraintsForRow(1).percentHeight = 100.0
        }
    }
}