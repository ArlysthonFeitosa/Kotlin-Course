package ClassesEnum

//Enumerar possibilidades
enum class Prioridade1() {
    BAIXA, MEDIA, ALTA
}

//override
enum class Prioridade2(val id: Int) {
    //BAIXA(1), MEDIA(8), ALTA(100)

    BAIXA(1) {
        override fun toString(): String {
            return "Super baixa, não se preocupe"
        }
    },
    MEDIA(8), ALTA(100)

}

//class Alarme(var desc: String, p: Prioridade2)

fun main() {
    //Alarme("Isso é um aviso", Prioridade2.ALTA)

    for (p in Prioridade2.values()) {
        println("$p - ${p.id} - ${p.ordinal}")
    }

    println(Prioridade2.BAIXA)
}