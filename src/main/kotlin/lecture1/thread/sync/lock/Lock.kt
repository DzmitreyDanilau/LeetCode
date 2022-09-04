package lecture1.thread.sync.lock

fun main() {
    val inventoryCounter = InventoryCounter()

    val incrementThread = lecture1.thread.sync.monitor.IncrementThread(inventoryCounter)
    val decrementThread = lecture1.thread.sync.monitor.DecrementThread(inventoryCounter)

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
    private val incrementLock = Unit
    private val decrementLock = Unit
    private var counter = 0

    @Synchronized
    fun increment() {
        synchronized(incrementLock) {
            counter++
        }
    }

    @Synchronized
    fun decrement() {
        synchronized(decrementLock) {
            counter--
        }
    }

    @Synchronized
    fun getCounter() = counter
}

