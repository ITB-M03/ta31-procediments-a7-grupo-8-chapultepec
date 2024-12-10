package org.example.controllers
import utilities.*


/**
 *
 */
fun definirArray() : Array<Char> {
    val ochenta = 80

    var array = Array<Char>(ochenta, { ' ' })

    return array
}

/**
 *
 */
fun guardarTamanyo(titulo : String) : Int {
    var tamanyo = titulo.length

    return tamanyo
}
/**
 *
 */
fun inicioDeLaPalabra(array : Array<Char>, tamanyo: Int) : Int {
    var inicioPalabra = (array.size - tamanyo) / 2

    return inicioPalabra
}
/**
 *
 */
fun centrarTitulo(array: Array<Char>, inicioPalabra : Int, titulo : String) : Array<Char> {
    var inicioPalabraCont = inicioPalabra
    for(i in titulo) {
        array[inicioPalabraCont] = i
        inicioPalabraCont++
    }
    return array
}

/**
 *
 */
fun mostrarPorPantalla(array: Array<Char>) {
    for (i in 0 until array.size) {
        print(" ${array[i]} ")
    }
}

/**
 *
 */
fun main () {
    var scan = abrirScanner()

    var array = definirArray()

    var titulo = leerLinea("Digame un titulo para centralo, gracias: ", scan)

    var tamanyo = guardarTamanyo(titulo)

    var inicioPalabra = inicioDeLaPalabra(array, tamanyo)

    array = centrarTitulo(array, inicioPalabra, titulo)

    mostrarPorPantalla(array)

    cerrarScanner(scan)
}