package GettersSettersFieldWith

class Pessoa(var nome: String) {

    //Não precisa get e set, apenas se quiser fazer algo junto, como um print
    var idade: Int = 0
        get() {
            return field
        }
        set(value) {
            field = value
        }

    fun ligar() {

    }

    fun processar() {

    }

    fun desligar() {

    }
}

fun main() {
    var p1: Pessoa = Pessoa("Arlysthon")
    println(p1.idade)
    p1.idade = 10
    println(p1.idade)

    /*
    p1.ligar()
    p1.processar()
    p1.desligar()
    */

    with(p1) {
        ligar()
        processar()
        desligar()
    }
}