package Abstratas

//Abstract class não pode ser inicializada
//Definir comportamentos para que outras possam herdar
abstract class Mamifero(var nome: String) {

    var peso:Float = 0f

    //as classes que herdam, são obrigadas a inicializar a função de acordo com a classe
    abstract fun falar()
    open fun dormir(){
        println("estou indo dormir")
    }
}

class Cachorro(nome: String, meuPeso:Float) : Mamifero(nome) {

    init{
        this.peso = meuPeso
    }

    override fun falar() {
        println("au au")
    }
}

class Gato(nome: String) : Mamifero(nome) {
    override fun falar() {
        println("miau")
    }
}

fun main() {

    val cachorro: Cachorro = Cachorro("Carlos", 20.0f)
    val gato:Gato = Gato("João")

    cachorro.falar()
    cachorro.dormir()

    gato.falar()
    gato.dormir()

    println(cachorro.peso)
}