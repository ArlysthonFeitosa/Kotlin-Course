package DataClass

/*
//DataClass - Apenas para transitar dados
data class Pessoa(var nome: String, var idade: Int)

fun teste(pessoa: Pessoa) {
    Pessoa("Arlysthon", 16)
}
 */

class Quadrado(val area: Float) {

}

data class Triangulo(val area: Float, val lado: Float)

fun main() {

    val q1 = Quadrado(10f)
    val q2 = Quadrado(10f)

    val t1 = Triangulo(10f, 5f)
    val t2 = Triangulo(10f, 5f)

    println(q1) //DataClass.Quadrado@330bedb4
    println(t1) //Triangulo (area=10.0, lado=5.0)

    /*
    Para imprimir a Class Quadrado de forma legível, teria que fazer:
        override fun toString(): String{
        return "area = $area"
    }
    */


    println(q1 == q2) //Sem "data class" ele compara as posições(endereços) na memória
    println(t1 == t2) //Com "data class" ele compara os valores

    /*
    Para a class Quadrado comparar os valores e não o endereço na memória:
        override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }
    */


    //copia o objeto t2 para o objeto t3
    val t3 = t2.copy()
    println(t3)

    //Não dá para fazer ${val q3 = q2.copy}, pois não existe o método


}
