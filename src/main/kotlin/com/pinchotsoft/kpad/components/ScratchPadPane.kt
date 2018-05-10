package com.pinchotsoft.kpad.components

import com.pinchotsoft.kpad.components.factories.EditorFactory
import com.pinchotsoft.kpad.util.Constants
import com.pinchotsoft.pubsub.Messenger
import javafx.event.EventHandler
import javafx.scene.control.Tab
import javafx.scene.control.TabPane
import javafx.scene.layout.GridPane
import tornadofx.*

class ScratchPadPane : View() {
    override val root = GridPane()

    private var unknownPadCount = 1
    private val tabPane: TabPane

    init {
        tabPane = createRootTabPane()

        with (root) {
            constraintsForColumn(0).percentWidth = 100.0

            row {
                this += tabPane
            }

            constraintsForRow(1).percentHeight = 100.0
        }

        Messenger.subscribe(this) {
            if (it.message == Constants.NEW_SCRATCHPAD)
                createNewScratchPad()
            else if (it.message == Constants.CLOSE_SCRATCHPAD)
                closeCurrentScratchPad()
        }
    }

    private fun createRootTabPane(): TabPane {
        val tabPane = TabPane()

        with (tabPane) {
            tab("ScratchPad ${unknownPadCount++}") {
                this += EditorFactory.createEditor(this.text)
            }

            tab("+") {
                isClosable = false

                onSelectionChanged = EventHandler {
                    if (isSelected) {
                        createNewScratchPad()
                    }
                }
            }
        }

        return tabPane
    }

    private fun createNewScratchPad() {
        val tabTitle = "ScratchPad ${unknownPadCount++}"

        this.tabPane.tabs.add(this.tabPane.tabs.size - 1, Tab(tabTitle, EditorFactory.createEditor(tabTitle).root))
        this.tabPane.selectionModel.select(this.tabPane.tabs.size - 2)
    }

    private fun closeCurrentScratchPad() {
        tabPane.tabs.remove(tabPane.selectionModel.selectedItem)
    }
}