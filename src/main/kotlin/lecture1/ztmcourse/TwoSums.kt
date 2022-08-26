package lecture1.ztmcourse

fun main() {
    val targetSum = 9
    val nums = arrayOf(1, 1, 7, 5)

    val result = getDesiredIndexes(nums, targetSum)

    print(result?.let { array -> array.contentToString() } ?: "There is no such sum")

}

// Complexity O(n)
fun getDesiredIndexes(nums: Array<Int>, targetSum: Int): IntArray? {

    val map = hashMapOf<Int, Int>()

    for (i in nums.indices) {
        val exceptedKey = targetSum - nums[i]
        if (map.containsKey(exceptedKey)) {
            return intArrayOf(map[exceptedKey]!!, i)
        } else {
            map[nums[i]] = i
        }
    }

    return null
}

// Complexity O(n^2)
fun getDesiredIndexes1(nums: Array<Int>, targetSum: Int): IntArray? {
    for (i in nums.indices) {
        for (j in i + 1 until nums.size) {
            if (nums[i] + nums[j] == targetSum) {
                intArrayOf(nums[i], nums[j])
            }
        }
    }

    return null
}