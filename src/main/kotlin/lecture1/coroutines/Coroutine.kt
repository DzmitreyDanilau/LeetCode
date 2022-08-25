package lecture1.coroutines

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {

    val deffered1 = async(start = CoroutineStart.LAZY) {
        getData("Deffered1")
    }

    val deffered2 = async {
        getData("Deffered2")
    }

//    val res = deffered1.start()
//    println("Start res $res")

    val result = listOf(deffered1.await(), deffered2.await())
    println("Await result $result")

}

private suspend fun getData(data: String): String {
    delay(500)
    println("getData() + $data")
    return data
}