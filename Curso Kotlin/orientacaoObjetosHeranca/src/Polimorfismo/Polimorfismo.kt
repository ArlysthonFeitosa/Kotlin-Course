package Polimorfismo

interface Funcionario {
    fun calculaBonus() {

    }
}

class Gerente : Funcionario {
    override fun calculaBonus() {
        var bonus = 500
        println(bonus)
    }
}

class Tecnico : Funcionario {
    override fun calculaBonus() {
        var bonus = 200
        println(bonus)
    }
}

fun main() {
    val f: Funcionario = Gerente()
    val f2: Funcionario = Tecnico()

}

fun calculo(f: Funcionario) {
    /*
    Evitar Overload
    fun calculo(f: Gerente) {}
    fun calculo(f:Tecnico) {}
     */
}
