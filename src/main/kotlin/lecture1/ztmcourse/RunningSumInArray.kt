package lecture1.ztmcourse


fun main() {
    val array = intArrayOf(1, 2, 3, 4)

    // initialArray = [1,2,3,4]
    // expectedArray = [1,3,6,10]
    val result = getSumArray2(array)

    print(result.contentToString())
}

// Time complexity O(n)
fun getSumArray2(array: IntArray): IntArray {
    for (i in 1 until array.size) {
        array[i] +=  array[i-1]
    }

    return array
}

// Time complexity O(n)
// Memory complexity O(n)
fun getSumArray1(array: IntArray): IntArray {
    val expectedArray = IntArray(array.size)
    expectedArray[0] = array[0]
    for (i in 1 until array.size) {
        expectedArray[i] = expectedArray[i - 1] + array[i]
    }

    return expectedArray
}