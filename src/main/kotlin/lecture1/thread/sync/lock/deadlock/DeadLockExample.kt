package lecture1.thread.sync.lock.deadlock

import java.util.*

fun main() {
    val intersection = Intersection()

    val trainOneThread = Thread(TrainOne(intersection))
    val trainTwoThread = Thread(TrainTwo(intersection))


    trainOneThread.start()
    trainTwoThread.start()

}

class TrainOne(private val intersection: Intersection) : Runnable {
    private val random = kotlin.random.Random(100)
    override fun run() {
        while (true) {
            val sleepingTime = random.nextLong(from = 0 , until = 10)
            Thread.sleep(sleepingTime)
            intersection.takeRoadOne()
        }
    }
}

class TrainTwo(private val intersection: Intersection) : Runnable {
    private val random = kotlin.random.Random(100)
    override fun run() {
        while (true) {
            val sleepingTime = random.nextLong(from = 0 , until = 10)
            Thread.sleep(sleepingTime)
            intersection.takeRoadTwo()
        }
    }
}

class Intersection {
    private val roadOne = Any()
    private val roadTwo = Any()

    fun takeRoadOne() {
        synchronized(roadOne) {
            println("Road  one is blocked by thread: ${Thread.currentThread().name}")
            synchronized(roadTwo) {
                println("Train is passing throught road one")
                Thread.sleep(1)
            }
        }
    }

    fun takeRoadTwo() {
        synchronized(roadTwo) {
            println("Road two is blocked by thread: ${Thread.currentThread().name}")
            synchronized(roadOne) {
                println("Train is passing throught road two")
                Thread.sleep(1)
            }
        }
    }
}
