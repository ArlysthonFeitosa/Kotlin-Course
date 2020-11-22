package Field

class Car(val model:String, val maxSpeed:Int){
    var currentSpeed:Int = 0  //private set - Não seria possível setar um valor para current Speed
        set(value) {
            if(value > maxSpeed){
                throw Exception ("Velocidade maior do que permitida")
            } else{
                field = value
            }
        }
}

fun main(args: Array<String>) {
    var c1 = Car("", 220)
    c1.currentSpeed = 100
}