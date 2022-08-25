import java.util.*

fun main() {

    var test = 1

    val action = Runnable {
        val newTest = test
        test ++
        print(test)
    }

    action.run()
}


