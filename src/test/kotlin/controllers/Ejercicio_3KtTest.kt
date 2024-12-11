package controllers

import org.example.controllers.chekPassw
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Ejercicio_3KtTest{
    @Test
    fun CkeckComparacionPassWordIntroducida() {
        var expecting = true
        assertEquals( expecting, chekPassw("Tomate", "Tomate"))
        expecting = false
        assertEquals( expecting, chekPassw("Tomate", "toomatito"))
        expecting = true
        assertEquals( expecting, chekPassw("IoSonoSudo", "IoSonoSudo"))
    }
}