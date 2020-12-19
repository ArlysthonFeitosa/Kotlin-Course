package SbEscritaESbCarga

open class Maquina(val marca: String) {
    //open para deixar ser sobrescrita
    open fun minhaMarca() {
        println("Minha marca é $marca")
    }
}

class Computador(marca: String, val nucleos: Int) : Maquina(marca) {
    override fun minhaMarca() {
        //Aqui eu posso fazer alguma implementação Extra
        val id = 100

        //super - chamando a classe pai
        super.minhaMarca()
    }

    fun ligar() {}
    fun processar() {}

    //sobrecarga - funções com parâmetros diferentes, mesmo com nomes iguais
    fun overload(i: Int) = println("Overload 1")
    fun overload(i: String) = println("Overload 2")
}

fun main() {
    val comp: Computador = Computador("Samsumg", 10)
    with(comp) {
        ligar()
        processar()
        minhaMarca()
    }
}