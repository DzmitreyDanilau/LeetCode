package lecture1

fun main() {

    val thread = Thread {
        println("We are now in the thread ${Thread.currentThread().name}")
        println("Current thread priority is ${Thread.currentThread().priority}")
    }

    thread.priority = Thread.MAX_PRIORITY
    thread.name = "WorkerThread"

    println("We are in thread ${Thread.currentThread().name} before start a new thread")
    thread.start()
    println("We are in thread ${Thread.currentThread().name} after start a new thread")
}