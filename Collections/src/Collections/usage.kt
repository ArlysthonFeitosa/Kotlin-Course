package Collections

data class Ingredientes(val nome: String, val quantidade: Int)
data class Receita(val nome: String, val calorias: Int, val ingredientes: List<Ingredientes> = listOf())

fun main() {

    // Cria lista de dados
    val data = listOf(
            Receita(
                    "Lasanha", 1200,
                    listOf(
                            Ingredientes("Farinha", 1),
                            Ingredientes("Presunto", 5),
                            Ingredientes("Queijo", 10),
                            Ingredientes("Molho de tomate", 2),
                            Ingredientes("Manjerição", 3)
                    )
            ),
            Receita("Panqueca", 500),
            Receita("Omelete", 200),
            Receita("Parmegiana", 700),
            Receita("Sopa de feijão", 300),
            Receita(
                    "Hamburguer", 2000,
                    listOf(
                            Ingredientes("Pão", 1),
                            Ingredientes("Hamburguer", 3),
                            Ingredientes("Queijo", 1),
                            Ingredientes("Catupiry", 1),
                            Ingredientes("Bacon", 3),
                            Ingredientes("Alface", 1),
                            Ingredientes("Tomate", 1)
                    )
            )
    )

    // Tenho receitas na lista?
    println("Tenho receitas? ${if (data.any()) "sim" else "não"}")

    // Quantas receitas tenho na coleção?
    println("Tenho ${data.count()} receitas")

    // Qual a primeira e última receita?
    println("A primeira é: ${data.first().nome}")
    println("A última é: ${data.last().nome}")

    // Qual a soma de calorias?
    val somaCal = data.sumBy { it.calorias }
    println("A soma de calorias é: $somaCal")

    // Me dê as duas primeiras receitas
    val primeiras = data.take(2)
    for (x in primeiras.withIndex()) {
        println("${x.index + 1} -> ${x.value.nome}")
    }

}