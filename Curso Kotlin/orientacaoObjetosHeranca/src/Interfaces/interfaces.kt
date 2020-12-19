package Interfaces

interface Maquina {
    //interface não herda, implementa
    //Contrato que quem implementa tem que assinar
    //Quem implementa a interface, tem que usar tudo que ela propõe
    //Nada é inicializado, apenas declarado

    //var peso:Float

    fun ligar() {}
    fun desligar() {
        println("desliguei")
    }
}

//class Computador(override var peso:Float) : Maquina{
class Computador() : Maquina {
    override fun ligar() {}
}

interface interface1 {
    fun ola() {
        println("Interface1")
    }
}

interface interface2 {
    fun ola() {
        println("Interface2")
    }
}

class ImplementaInterface : interface1, interface2 {
    //Como as duas interfaces têm o mesmo método, um override vale pelos dois
    override fun ola() {
        super<interface1>.ola()
        //Não entende o {super.ola()} porque existem duas funções iguais
    }

}

fun main() {
    var pessoa: ImplementaInterface = ImplementaInterface()

    pessoa.ola() //print na interface 1, já que no override eu dei super<interface1>.ola

}