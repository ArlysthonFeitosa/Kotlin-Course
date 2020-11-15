package Heranca

//Open para deixar outras classes herdarem
open class Maquina(val marca: String) {
    fun minhaMarca() {
        println("Minha marca é $marca")
    }
}

//Herança de Máquina
class Computador(marca: String, val nucleos: Int) : Maquina(marca) {
    fun ligar(){
        println("oi")
    }

    fun processar() {

    }
}

fun main() {
    val comp: Computador = Computador("Samsumg", 10)
    with(comp) {
        ligar()
        processar()
        minhaMarca()
    }
}