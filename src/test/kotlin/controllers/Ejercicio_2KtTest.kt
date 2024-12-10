package controllers

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Ejercicio_2KtTest {
    @Test
    fun CheckIntoRomanNumbers () {
        var expecting = "DCLXXVIII"
        assertEquals( expecting , intToRoman(678))
        expecting = "MMMCMXCIX"
        assertEquals( expecting , intToRoman(3999))
        expecting = "XXIII"
        assertEquals( expecting , intToRoman(23))
    }
}
