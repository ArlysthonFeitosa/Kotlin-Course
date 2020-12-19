package FuncoesInfix

//quando a função recebe um parâmetro pode usar infix para escrever melhor a fun
infix fun Int.isHalfOf(value: Int) = value / 2 == this


fun main(args: Array<String>) {
    10.isHalfOf(20)
    10 isHalfOf 20 //por causa do infix pode escrever assim
}