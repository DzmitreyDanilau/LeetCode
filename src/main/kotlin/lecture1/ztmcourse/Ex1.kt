package lecture1.ztmcourse

fun main() {
    val array1 = arrayOf("x", "y", "b", "w")
    val array2 = arrayOf("a", "t", "x")
    val test = listOf<String>()
    val resultMap = isContainsSameValueMap(array1, array2)
    val resultSet = isContainsSameValueSet(array1, array2)

    println("Has same values (map): $resultMap")
    println("Has same values (set): $resultSet")
}

fun isContainsSameValueSet(array1: Array<String>, array2: Array<String>): Boolean {
    val set = mutableSetOf<String>()
    array1.forEach {
        if (!set.contains(it)) {
            set.add(it)
        }
    }

    println("Set: $set")

    array2.forEach {
        if (set.contains(it)) {
            return true
        }
    }
    return false
}

fun isContainsSameValueMap(array1: Array<String>, array2: Array<String>): Boolean {
    val map = mutableMapOf<String, Boolean>()
    array1.forEach {
        if (!map.contains(it)) {
            map[it] = true
        }
    }

    println("Map: $map")

    array2.forEach {
        if (map.contains(it)) {
            return true
        }
    }
    return false
}