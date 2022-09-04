package lecture1.thread.sync.valotile

import java.lang.Exception
import kotlin.random.Random

fun main() {
    val metrics = Metrics()

    val blThread1 =BusinessLogicThread(metrics)
    val blThread2 = BusinessLogicThread(metrics)

    val metricsPrinter = MetricsPrinter(metrics)


    blThread1.start()
    blThread2.start()
    metricsPrinter.start()
}

class Metrics() {
    private var count = 0L

    @Volatile
    private var average = 0.0

    @Synchronized
    fun addSample(sample: Long) {
        val currentSum = average * count
        count = count + 1
        average = (currentSum + sample) / count
    }

    fun getAverage(): Double {
        return average
    }
}

class BusinessLogicThread(private val metrics: Metrics) : Thread() {
    private val random = Random(100)

    override fun run() {
        while (true) {
            val start = System.currentTimeMillis()
            try {
                Thread.sleep(random.nextLong())
            } catch (e: Exception) {

            }
            val end = System.currentTimeMillis()

            println("Start $start")
            println("End $end")
            println("Result ${end-start}")

            metrics.addSample(end - start)
        }
    }
}

class MetricsPrinter(private val metrics: Metrics) : Thread() {
    override fun run() {
        while (true) {
            try {
                Thread.sleep(100)
            } catch (e: Exception) {

            }
            val currentAverage = metrics.getAverage()
//            println("Current average: $currentAverage")
        }
    }

}