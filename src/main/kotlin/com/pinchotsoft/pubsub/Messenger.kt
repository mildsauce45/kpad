package com.pinchotsoft.pubsub

class Messenger {
    companion object {
        private val listeners = HashMap<Any, (Message) -> Unit>()

        fun subscribe(receiver: Any, handler: (Message) -> Unit) {
            listeners[receiver] = handler
        }

        fun unsubscribe(receiver: Any) {
            if (listeners.containsKey(receiver))
                listeners.remove(receiver)
        }

        fun publish(message: Message) {
            if (listeners.isNotEmpty())
                listeners.values.forEach { it(message) }
        }
    }
}