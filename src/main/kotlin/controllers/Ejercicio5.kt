package org.example.controllers
import utilities.*
import java.util.Scanner

/**
 *
 */
fun menu(scan : Scanner) : Int {
    var opciones : Int

    print("Buenas tardes. \n" +
            "Opcion 1: Introducir un numero (push) \n" +
            "Opcion 2: Eliminar un numero (pop) \n" +
            "Opcion 3: Mostrar contenido de la pila \n" +
            "Opcion 4: Salir del programa \n")

    opciones = pedirNumerito("Me gustaria que me dijeses el numero de tu opcion: ", scan)

    return opciones
}

/**
 *
 */
fun bucle(scan : Scanner) {
    var opciones = 0
    val cuatro = 4

    while(opciones != cuatro){
        opciones = menu(scan)
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
    numero = pedirNumerito("Digame el numero que quiere introducir: ", scan)

    pila.add(numero)

    return pila
}

/**
 *
 */
fun eliminarNumero(pila : MutableList<Int>) : MutableList<Int> {

    return pila
}

/*
 *
 */
fun mostrarUltimo(pila: MutableList<Int>, msg : String) : Int {
    var ultimo : Int
    ultimo = pila.last()

    return ultimo
}