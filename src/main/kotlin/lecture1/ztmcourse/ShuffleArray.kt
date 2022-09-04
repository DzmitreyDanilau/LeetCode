package lecture1.ztmcourse

fun main() {
    val array = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8)

    val startIndex = 4

    val result = shuffleArray(array, startIndex)

    println(result.contentToString())
}

//Time complexity O(n)
//Memory complexity O(n)
fun shuffleArray(nums: IntArray, n: Int): IntArray {
    val expected = IntArray(n * 2)

    for (i in 0 until n) {
        expected[i * 2] = nums[i]
        expected[(i * 2) + 1] = nums[i + n]
    }

    return expected
}

// [1,2,3,4,5,6,7,8]
// n = 4
// [1,5,2,6,3,7,4,8]