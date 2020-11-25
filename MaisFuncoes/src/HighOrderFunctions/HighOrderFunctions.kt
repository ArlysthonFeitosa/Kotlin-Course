package HighOrderFunctions

//op é uma função com dois parâmetros inteiros que retorna um inteiro
fun operator(x: Int, y: Int, op: (Int, Int) -> Int): Int {
    val ret = op(x, y)
    return ret
}

fun sum(x: Int, y: Int) = x + y

fun multiply(x: Int, y: Int) = x * y

fun List<Int>.paraCada(op: (Int) -> Unit) {
    for (i in this) {
        op(i)
    }
}

/*
Só funciona com lista Int
fun List<Int>.paraCada(op: (Int) -> Unit) { }

Funciona com lista de qualquer tipo
fun <T> List<T>.paraCada(op: (T) -> Unit) { }

Collection herda Interable, por isso agora funciona com qualquer lista
fun <T> Iterable<T>.paraCada(op: (T) -> Unit) { }

 */

fun main() {
    val list = listOf(1, 2, 3, 4)
    //list.forEach { println(it) }
    list.paraCada { println(it) }

    //passando a função por parâmetro
    operator(1, 2, ::sum)
    operator(1, 3, ::multiply)
}