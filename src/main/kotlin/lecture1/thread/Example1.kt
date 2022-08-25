package lecture1.thread

import kotlinx.coroutines.async
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    println("Main starts")
    joinAll(
        async{ coroutine(1, 500) },
        async{ coroutine(2, 200) }
    )
    println("Main ends")

    val list1 = mutableListOf<String>()

    list1.distinctBy {

    }
}


private suspend fun coroutine(number: Int, delay: Long) {
    println("Coroutine $number starts work")
    println("in suspend Thread ${Thread.currentThread().name}")
    calculateSomething(delay)
    println("Coroutine $number has finished")
}

fun calculateSomething(boundery: Long) {
    println("Thread ${Thread.currentThread().name}")
    for (i in 0..boundery) {
    }
}