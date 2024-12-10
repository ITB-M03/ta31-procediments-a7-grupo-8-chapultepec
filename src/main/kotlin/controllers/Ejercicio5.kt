package org.example.controllers
import utilities.*
import java.util.Scanner

/**
 *
 */
fun menu(scan : Scanner) : Int {
    var opciones : Int

    print("--------------------------------------------- \n" +
            "Buenas tardes. \n" +
            "Opcion 1: Introducir un numero (push) \n" +
            "Opcion 2: Eliminar un numero (pop) \n" +
            "Opcion 3: Mostrar contenido de la pila \n" +
            "Opcion 4: Salir del programa \n" +
            "-------------------------------------------- \n")

    opciones = pedirNumerito("Me gustaria que me dijeses el numero de tu opcion: ", scan)

    return opciones
}

/**
 *
 */
fun bucle(scan : Scanner, pila: MutableList<Int>) {
    var opciones = 0
    val cuatro = 4
    val uno = 1
    val dos = 2
    val tres = 3
    val white = "\u001b[0m"
    val green = "\u001b[32m"

    while(opciones != cuatro){
        opciones = menu(scan)
        if(opciones == 1){
            introducirUnNumero(scan, pila)
        }
        else if(opciones == 2){
            eliminarNumero(pila)
        }
        else if(opciones == 3){
            mostrarContenido(pila)
        }
        else if(opciones == 4){
            mostrarMensajeSinSalto( green + "Gracias por probar la app" + white)
        }
    }
}

/**
 *
 */
fun definirPila() : MutableList<Int> {
    var pila : MutableList<Int> = mutableListOf()

    return pila
}

/**
 *
 */
fun introducirUnNumero(scan : Scanner, pila : MutableList<Int>) : MutableList<Int> {
    var numero : Int
    val diez = 10
    val red = "\u001b[31m"
    val white = "\u001b[0m"

    numero = pedirNumerito("Digame el numero que quiere introducir: ", scan)

    if(pila.size <= diez){
        pila.add(numero)
    }
    else printlnMSG(red + "NO, eso no se puede, la pila esta llena" + white)

    return pila
}

/**
 *
 */
fun eliminarNumero(pila : MutableList<Int>) : MutableList<Int> {
    val red = "\u001b[31m"
    val white = "\u001b[0m"
    mostrarUltimo(pila)

    try {
        pila.removeLast()
    }
    catch ( e : NoSuchElementException){
        printlnMSG(red + "Esto no se puede hacer, la pila esta vacia :(" + white)
    }

    return pila
}

/**
 *
 */
fun mostrarUltimo(pila: MutableList<Int>){
    var ultimo : Int
    ultimo = pila.last()

    mostrarMensajeSinSalto("El numero que has eliminado es: $ultimo \n")
}

/**
 *
 */
fun mostrarContenido(pila: MutableList<Int>) {
    mostrarMensajeSinSalto("Este es el contenido de la pila actualmente: $pila \n" )
}

/**
 *
 */
fun main() {
    var scan = abrirScanner()

    var pila = definirPila()

    bucle(scan, pila)

    cerrarScanner(scan)
}