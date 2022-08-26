package lecture1.ztmcourse

fun main() {
    val nums = intArrayOf(1, 0, 2, 0, 12, 21)
    val result = moveZero(nums)

    print(result.contentToString())
}
// Memory optimized
// without additional array/list
// Complexity O(n)
// Memory complexity O(1)
internal fun moveZero(nums: IntArray): IntArray {
    var fastPointer = 0
    var slowPointer = 0
    while (fastPointer < nums.size) {
        if (nums[fastPointer] == 0) {
            fastPointer++
        } else {
            val temp = nums[fastPointer]
            nums[fastPointer] = nums[slowPointer]
            nums[slowPointer] = temp
            fastPointer++
            slowPointer++
        }
    }
    return nums
}


// create new array
// Complexity 0(n)
// Memory complexity O(n)
internal fun moveZero1(nums: IntArray): IntArray {

    val result = mutableListOf<Int>()
    var counter = 0
    for (i in nums.indices) {
        if (nums[i] != 0) {
            result.add(nums[i])
        } else {
            counter++
        }
    }

    println("Zeros q: $counter")

    for (i in 0 until counter) {
        result.add(0)
    }

    return result.toIntArray()
}