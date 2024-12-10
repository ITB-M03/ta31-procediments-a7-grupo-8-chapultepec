package org.example.controllers
import utilities.*

/**
 * Convertir numero entero a romano
 * @author Iván Salamanca
 * @param num --> Numero entero a comvertir
 * @return --> Numero romano tipo string ya que no dejan de ser letras
 */
fun intToRoman(num: Int): String {
    val romanNumerals = listOf(
        // Equivalencia a números romanos
        1000 to "M",
        900 to "CM",
        500 to "D",
        400 to "CD",
        100 to "C",
        90 to "XC",
        50 to "L",
        40 to "XL",
        10 to "X",
        9 to "IX",
        5 to "V",
        4 to "IV",
        1 to "I"
    )

    var number = num
    var result = ""

    for ((value, roman) in romanNumerals) {
        while (number >= value) {
            result += roman  // Concatenación directa de cadenas
            number -= value
        }
    }

    return result
}

/**
 * Funcion Main contiene el codigo ejecutable
 * @author Iván Salamanca
 */
fun main() {
    var scan = abrirScanner()
    printlnMSG("Vamos a pasar numeros enteros a numeros Romanos")
    var numeroInt = pedirNumerito("Intoduce un numero entero: ", scan)
    var numRomano = intToRoman(numeroInt)
    showResulString("El numero en Romano es :",numRomano )


}