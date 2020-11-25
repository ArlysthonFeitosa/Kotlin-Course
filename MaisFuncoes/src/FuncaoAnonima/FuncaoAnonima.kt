package FuncaoAnonima

fun operator(x: Int, y: Int, op: (Int, Int) -> Int): Int {
    val ret = op(x, y)
    return ret
}

fun main() {

    //Com a função anonima, posso escrever um código livre
    operator(1, 3, fun(n1: Int, n2: Int): Int {
        var novaVariavel: Int = 0
        if (novaVariavel++ == 1) { }
        return novaVariavel
    })
}