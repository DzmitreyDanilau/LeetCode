package lecture1.thread.sync.monitor

import lecture1.thread.sync.lock.InventoryCounter

fun main() {
    val inventoryCounter = InventoryCounter()

    val incrementThread = lecture1.thread.sync.lock.IncrementThread(inventoryCounter)
    val decrementThread = lecture1.thread.sync.lock.DecrementThread(inventoryCounter)

    incrementThread.start()
    decrementThread.start()

    incrementThread.join()
    decrementThread.join()

    println("We currently have " + inventoryCounter.getCounter() + " items.")
}

class IncrementThread(private val inventoryCounter: InventoryCounter) : Thread() {

    override fun run() {
        for (i in 0 until 1000 step 1) {
            inventoryCounter.increment()
        }
    }
}

class DecrementThread(private val inventoryCounter: InventoryCounter) : Thread() {

    override fun run() {
        for (i in 0 until 1000 step 1) {
            inventoryCounter.decrement()
        }
    }
}

class InventoryCounter() {
    private var counter = 0

    @Synchronized
    fun increment() = counter++

    @Synchronized
    fun decrement() = counter--

    @Synchronized
    fun getCounter() = counter
}

