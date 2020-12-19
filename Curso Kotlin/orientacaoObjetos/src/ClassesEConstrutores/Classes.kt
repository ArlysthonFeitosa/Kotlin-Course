package ClassesEConstrutores

class Pessoa(var nome: String, val nascimento: Int) {

}

//Construtor
class Pessoa1(var nome: String) {

    var ano: Int? = null

    constructor(nome: String, ano: Int) : this(nome) {
        this.ano = ano
    }

    fun saudacoes() {
        println("Olá, meu nome é $nome")
        println(ano)
    }
}

fun main() {
    val p1: Pessoa1 = Pessoa1("Arlysthon")
    val p2: Pessoa1 = Pessoa1("Arlysthon", 2004)
    p1.saudacoes()
    p2.saudacoes()
}