package exercises

import org.junit.Assert
import org.junit.Test

class VowelConsonantTest {

    @Test
    fun countVowels() {
        Assert.assertEquals(2, countVowels("Arlysthon"))
    }

    @Test
    fun countConsonants() {
        Assert.assertEquals(7, countConsonants("Arlysthon"))
    }

    @Test
    fun countVowelsAndConsonants() {
        var phrase = "Arlysthon"
        Assert.assertEquals(2, countVowels(phrase))
        Assert.assertEquals(7, countConsonants(phrase))
    }

    @Test
    fun countVowelsFilter(){
        Assert.assertEquals(2, countVowelsFilter("Arlysthon"))
    }
}