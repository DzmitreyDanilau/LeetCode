package lecture1.ztmcourse

import java.util.*

fun main() {

    val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7)

    val k = 3

    val iteration = k % nums.size

    reverse(nums, start = 0, end = nums.size - iteration - 1)
    reverse(nums, start = nums.size - iteration, end = nums.size - 1)
    reverse(nums, start = 0, end = nums.size - 1)

    print(Arrays.toString(nums))
}

internal fun reverse(nums: IntArray, start: Int, end: Int) {

    if (nums.isEmpty()) return

    var i = start
    var j = end
    var temp = 0
    while (i < j) {
        temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
        i++
        j--
    }
}