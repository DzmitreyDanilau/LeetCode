package lecture1.ztmcourse

// https://leetcode.com/problems/final-value-of-variable-after-performing-operations/
fun main() {
    val operationsList = arrayOf<String>("X--", "X--", "--X", "++X")

    val result = findOperationsresult(operationsList)

    print("Result: $result")
}

fun findOperationsresult(operations: Array<String>) : Int {
    var expectedResult = 0
    for(i in operations.indices){
        if(operations[i].contains("+")) {
            expectedResult++
        } else {
            expectedResult--
        }
    }
    return expectedResult
}