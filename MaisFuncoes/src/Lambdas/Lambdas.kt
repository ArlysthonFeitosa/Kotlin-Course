package Lambdas

import HighOrderFunctions.multiply
import HighOrderFunctions.sum
import kotlin.math.log2

fun operator(x: Int, y: Int, op: (Int, Int) -> Int): Int {
    val ret = op(x, y)
    return ret
}

fun sum(x: Int, y: Int) = x + y

fun multiply(x: Int, y: Int) = x * y

fun main() {

    operator(1, 2, ::sum)
    operator(1, 3, ::multiply)

    operator(1, 2, { a, b -> a + b })

    val l1 = { a: Int, b: Int -> a + b }
    operator(1, 2, l1)

    val l2: (Int, Int) -> Int = { u, i -> u + i }
    operator(1, 2, l2)
}