package exercises

fun countVowels(phrase: String): Int {
    val vowels = "aeiou"
    var count = 0

    for (letter in phrase) {
        if (letter.toLowerCase() in vowels) count++
    }
    return count

    /*
    var current = ""
    var count = 0
    for (a in 0..phrase.length - 1) {
        current = phrase[a].toString()
        if (current == "a" || current == "A") {
            count++
        } else if (current == "e" || current == "E") {
            count++
        } else if (current == "i" || current == "I") {
            count++
        } else if (current == "o" || current == "O") {
            count++
        } else if (current == "u" || current == "U") {
            count++
        }
    }
     */
}

fun countConsonants(phrase: String): Int {
    val consonants = "bcdfghjklmnpqrstvwxyq"
    var count = 0

    for (letter in phrase) {
        if (letter.toLowerCase() in consonants) count++
    }

    return count
    //return phrase.length - countVowels(phrase)
}

fun countVowelsFilter(phrase: String): Int{
    val vowels = "aeiou"
    return phrase.filter { it.toLowerCase() in vowels}.length
}