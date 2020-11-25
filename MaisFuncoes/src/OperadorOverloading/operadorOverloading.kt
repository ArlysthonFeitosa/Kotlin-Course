package OperadorOverloading

data class Fraction(val numerator: Int, val denominator: Int) {
    operator fun plus(fraction: Fraction): Fraction {
        if (denominator == fraction.denominator) {
            return Fraction(numerator + fraction.numerator, denominator)
        } else {
            val commun = denominator * fraction.denominator
            return Fraction(((commun / denominator) * numerator) +
                    ((commun / fraction.denominator) + fraction.denominator), commun)
        }
    }

    operator fun inc(): Fraction {
        return this
    }

}

fun main() {

    var f1: Fraction = Fraction(3, 2)
    var f2: Fraction = Fraction(5, 3)

    println(f1 + f2) //soma de fração usando uma classe
    f1++
}