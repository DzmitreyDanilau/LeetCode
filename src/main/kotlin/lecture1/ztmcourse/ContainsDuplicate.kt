package lecture1.ztmcourse

fun main() {
    val nums = intArrayOf(1, 2, 3, 4, 8, 3)
    val result = isContainsDuplicates(nums)

    print("Contains: $result")
}

internal fun isContainsDuplicates(nums: IntArray): Boolean {
    val hashSet = hashSetOf<Int>()

    for (index in nums.indices) {
        if (hashSet.contains(nums[index])) return true
        hashSet.add(nums[index])
    }

    return false
}


// Brute force
// Complexity (O^2)
internal fun isContainsDuplicates1(nums: IntArray): Boolean {
    for (i in nums.indices) {
        for (j in i + 1 until nums.size) {
            if (nums[i] == nums[j]) return true
        }
    }
    return false
}