package lecture1

fun main(args: Array<String>) {
    val thread = Thread(SleepingThread())
    thread.start()
    thread.interrupt()
}

private class SleepingThread : Runnable {
    override fun run() {
        while (true) {
            try {
                Thread.sleep(1000000)
            } catch (e: InterruptedException) {
                return
            }
        }
    }
}