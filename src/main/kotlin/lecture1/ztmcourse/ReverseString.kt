package lecture1.ztmcourse

fun main() {
    val inputValue = "Hi my name is Dima"
    reversString(inputValue)
}

private const val spliterator = " "
fun reversString(value: String) {
    val result = value.split(spliterator).toList().map {
        it.reversed()
    }.joinToString { spliterator }
    println(result)
}
