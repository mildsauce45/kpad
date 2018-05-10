package com.pinchotsoft.kpad.components

import com.pinchotsoft.kpad.util.Constants
import com.pinchotsoft.pubsub.Message
import com.pinchotsoft.pubsub.Messenger
import javafx.event.EventHandler
import javafx.scene.layout.BorderPane
import tornadofx.*

class MainMenu : View() {
    override val root = BorderPane()

    init {
        with (root) {
            center {
                menubar {
                    menu("File") {
                        item("New Scratchpad") {
                            onAction = EventHandler {
                                Messenger.publish(Message(Constants.NEW_SCRATCHPAD))
                            }
                        }

                        item("Open Scratchpad")

                        separator()

                        item("Close") {
                            onAction = EventHandler {
                                Messenger.publish(Message(Constants.CLOSE_SCRATCHPAD))
                            }
                        }

                        item("Exit") {
                            onAction = EventHandler {
                                System.exit(1)
                            }
                        }
                    }

                    menu("Edit") {

                    }
                }
            }
        }
    }
}