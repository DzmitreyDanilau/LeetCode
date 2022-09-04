package lecture1.ztmcourse

fun main() {
    val array = intArrayOf(1, 2, 3)
    val result = concatArray(array)

    print(result.contentToString())
}


//Complexity O(n)
//Memory complexity 0(n)
private fun concatArray(array: IntArray): IntArray {
    val result = IntArray(array.size * 2)
    for (i in result.indices) {
        val index = i % array.size
        result[i] = array[index]
    }

    return result
}