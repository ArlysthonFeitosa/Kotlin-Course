package InicializacaoTardia
//lateinit

class Pessoa{

    //Só vou inicializar essa variável depois de construir a classe
    lateinit var nome:String

    fun geradorDeNome(){
        nome = "Arlysthon"
    }
}

fun main() {

    val p = Pessoa()

    //Não posso mostrar uma variável não inicializada ainda -> println(p.nome)

    p.geradorDeNome()
    println(p.nome)

}