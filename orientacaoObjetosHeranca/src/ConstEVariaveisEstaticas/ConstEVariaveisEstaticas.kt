package ConstEVariaveisEstaticas

//private constructor - opcional para não poder instanciar a Classe
class Constantes private constructor(){

    //Para a classe que não precisa instanciar
    //Posso dar ou não um nome
    companion object BANCO{
        val TABLE = "Pessoa"

        fun printHW(){
            println("Hello World")
        }
    }

    //companion object != companion object
    //Precisa ter nome
    object VENDAS {
        val TABLE_NAME = "Vendas"

        //Pode criar outro object
        object COLUNAS{
            val ID = 10
        }
    }
}

fun main() {

    //Não precisou instanciar a classe para utilizá-la
    println(Constantes.TABLE)
    Constantes.printHW()
    Constantes.BANCO.TABLE

    Constantes.VENDAS.TABLE_NAME
    Constantes.VENDAS.COLUNAS.ID
}