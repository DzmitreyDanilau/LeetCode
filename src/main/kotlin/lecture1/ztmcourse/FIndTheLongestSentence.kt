package lecture1.ztmcourse

import kotlin.math.max

fun main() {
    val sentences = arrayListOf("alice and bob love leetcode", "i think so too", "this is great thanks very much")

    val result = theBiggestWords(sentences)

    println("The biggest words count: $result")

}

//Time complexity O(n)
fun theBiggestWords(sentences: ArrayList<String>): Int {
    var count = Int.MIN_VALUE
    sentences.forEach {
        count = max(count, it.split(" ").size)
    }

    return count
}
