package exercises

import java.lang.StringBuilder

fun reverseUsingSB(str: String): String {
    return StringBuilder(str).reverse().toString()
}

fun reverseUsingLoop(str: String): String {
    var strReverse: String = ""
    for (a in str.length - 1 downTo 0) {
        strReverse += str[a]
    }
    return strReverse
}