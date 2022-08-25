package lecture1.ztmcourse

fun main() {

    val array2 = arrayOf(1, 3, 4)
    val array1 = arrayOf(2, 4, 7, 10,11, 18)

    val result = mergeSortedArray2(array1, array2)

    result.forEach {
        println(it)
    }
}


internal fun mergeSortedArray2(array1: Array<Int>, array2: Array<Int>): IntArray {
    val finalArraySize = array1.size + array2.size

    val mergeResult = IntArray(finalArraySize)

    var i = 0
    var j = 0

    for (k in 0 until finalArraySize) {
        if (j >= array2.size || (i < array1.size && array1[i] <= array2[j])) {
            mergeResult[k] = array1[i]
            i++
        } else {
            mergeResult[k] = array2[j]
            j++
        }
    }

    return mergeResult
}

// Complexity O(n*log(n))
internal fun mergeSortedArray1(array1: Array<Int>, array2: Array<Int>): Array<Int> {

    val mergedList = mutableListOf<Int>()
    mergedList.addAll(array1)
    mergedList.addAll(array2)

    mergedList.sort()
    return mergedList.toTypedArray()
}