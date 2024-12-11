package controllers
import IVAPeriod
import calcularIVA
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class CalcularIvatest {

    @Test
    fun testCalcularIVAGeneral() {
        val fechaCompra = LocalDate.of(2020, 6, 15)
        val resultado = calcularIVA(100.0, "General", fechaCompra)
        assertEquals(112.0, resultado)
    }
}


class Ejercicio_1KtTest2 {

    @Test
    fun calcularIVAReducido() {
        val fechaCompra = LocalDate.of(2020, 6, 15)
        val resultadoReducido = calcularIVA(100.0, "Reducido", fechaCompra)
        assertEquals(106.0, resultadoReducido)
    }
}

class Ejercicio_1KtTest3 {

    @Test
    fun calcularIVAExento() {
        val fechaCompra = LocalDate.of(2020, 6, 15)
        val resultadoExcerp = calcularIVA(100.0, "Exento", fechaCompra)
        assertEquals(100.0, resultadoExcerp)
    }
}