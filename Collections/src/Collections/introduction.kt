package Collections

fun main() {

    val l1 = listOf("Arlysthon", "Arleykson") //Coleção imutável
    val l2 = mutableListOf("Arlysthon") //Coleção mutável

    val a1 = arrayListOf("Arlysthon", "Arleykson") //Array que vem do Java

    val s1 = setOf("Arlysthon","Arleykson") //Impede que elementos repetidos sejam inseriros
    val s2 = mutableSetOf("Arlysthon", "Arleykson")

    val m1 = mapOf(Pair("key", "value"), Pair("França", "Paris"))
    val m2 = mutableMapOf(Pair("key", "value"), Pair("França", "Paris"))

    //De de acordo com uma chave, consigo um valor - Implementa o Map
    val h1 = hashMapOf<String, String>(Pair("10", "Arlysthon"), Pair("11", "Arleykson"))

    println(h1.entries) // [11=Arleykson, 10=Arlysthon]
    println(h1["10"]) // Arlysthon
}