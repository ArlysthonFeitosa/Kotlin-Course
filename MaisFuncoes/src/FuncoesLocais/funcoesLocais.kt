package FuncoesLocais

import java.text.SimpleDateFormat
import java.util.*

//posso criar uma função log (mesmo nome) e não irá dar conflito

fun top(){
    fun log(str:String){
        val calendar = Calendar.getInstance()
        val formatted = SimpleDateFormat("HH:mm:ss")
        println("$str - ${formatted.format(calendar.time)}")
    }

    log("inicio")

    //delay
    val interval = 1..1000000000
    var sum = 10
    for (i in interval){ sum = sum*sum*sum*sum }

    log("fim")
}

fun main(args: Array<String>){
    top()
    //top().log() não dá, pois apenas a fun top consegue acessar a fun log
}