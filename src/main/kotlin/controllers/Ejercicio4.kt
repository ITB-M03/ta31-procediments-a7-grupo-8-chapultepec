package org.example.controllers
import utilities.*

/**
 * En esta funcion definimos el array que vamos a utilizar
 * @author Angel Sardinha
 * @return Se retorna un array de chars
 */
fun definirArray() : Array<Char> {
    val ochenta = 80

    var array = Array<Char>(ochenta, { ' ' })

    return array
}

/**
 * En esta funcion nos guardamos el tamanyo del array
 * @author Angel Sardinha
 * @param titulo --> Esto es el string del que vamos a guardar el tamanyo
 * @return Retornamos el tamanyo del string
 */
fun guardarTamanyo(titulo : String) : Int {
    var tamanyo = titulo.length

    return tamanyo
}
/**
 * En esta funcion Realizamos un calculo basico de mates para asi poder saber en que posicion inicia la palabra para que quede centrada
 * @author Angel Sardinha
 * @param array --> Esto es el array vacio de chars
 * @param tamanyo --> Esto es el tamanyo de la palabra
 * @return Retornamos un entero que indica la posicion de inicio de la palabra
 */
fun inicioDeLaPalabra(array : Array<Char>, tamanyo: Int) : Int {
    val dos = 2
    var inicioPalabra = (array.size - tamanyo) / dos

    return inicioPalabra
}
/**
 * En esta funcion centramos la palabra
 * @author Angel Sardinha
 * @param array --> Esta es el array de chars vacio
 * @param inicioPalabra --> Esta es la pocicion inicial de la palabra
 * @param titulo --> La palabra que se quiere centrar
 * @return Retronamos el array actualizado con la palabra centrada
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
 * Esta es una funcion que imprime por pantalla el array con la palabra centrada
 * @author Angel Sardinha
 * @param array --> Este es el array centrado
 */
fun mostrarPorPantalla(array: Array<Char>) {
    for (i in 0 until array.size) {
        print(" ${array[i]} ")
    }
}

/**
 * Esta es la magnifica funcion main que organiza lo que ocurre con el programa
 * @author Angel Sardinha
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