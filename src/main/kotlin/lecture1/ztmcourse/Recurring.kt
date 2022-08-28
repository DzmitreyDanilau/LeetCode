package lecture1.ztmcourse

fun main() {

    val nums = intArrayOf(33, 4, 1, 2, 3, 6, 33, 1)

    val result = findRecurrentItem(nums)

    println("Result: $result")

}

//Complexity 0(n)
//Memory complexity 0(1)
internal fun findRecurrentItem(array: IntArray): Int? {
    val map = HashMap<Int, Boolean>()

    for (i in array.indices) {

        if (map.containsKey(array[i])) return array[i]

        map[array[i]] = true
    }

    return null
}


// Complexity O(n^2)
internal fun findRecurrentItem1(array: IntArray): Int? {
    for (i in array.indices) {
        for (j in i + 1 until array.size) {
            if (array[i] == array[j]) return array[i]
        }
    }

    return null
}