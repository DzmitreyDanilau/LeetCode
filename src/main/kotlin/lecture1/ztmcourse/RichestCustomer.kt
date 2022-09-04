package lecture1.ztmcourse

fun main() {
    val array = listOf<IntArray>(intArrayOf(1, 2, 3), intArrayOf(5, 2, 1))

    val result = richestCustomerBalance2(array)

    print("Balance: $result")
}

// Time complexity O(n^2)
fun richestCustomerBalance1(customers: List<IntArray>): Int {
    var balance = 0
    for (i in customers.indices) {
        balance = balance.coerceAtLeast(customers[i].sum())
    }

    return balance
}


fun richestCustomerBalance2(customers: List<IntArray>): Int {
    var balance = 0
   val res =  customers.map {
        it.reduce { wealth, value -> wealth + value }
    }.max()

    return res
}