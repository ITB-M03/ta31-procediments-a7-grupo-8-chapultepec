package org.example.controllers
import utilities.*
import java.util.Scanner

/**
 * La magnifica funcion del menu que te ayuda a escoger tu opcion
 * @author Angel Sardinha
 * @since 1 - 0
 * @param scan --> El scanner que te ayuda a obtener cosas desde el teclado
 * @return Retorna la opcion que has elegido
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
 * La magnifica funcion main que te ayuda a organizar
 * @author Angel Sardinha
 * @since 1 - 0
 * @param scan --> El scanner que te ayuda a obtener los valores del teclado
 * @param pila --> La lista donde estan los valores
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
 * La magnifica funcion main que te ayuda a organizar
 * @author Angel Sardinha
 * @since 1 - 0
 * @return Retorna una lista vacia
 */
fun definirPila() : MutableList<Int> {
    var pila : MutableList<Int> = mutableListOf()

    return pila
}

/**
 * La magnifica funcion main que te ayuda a organizar
 * @author Angel Sardinha
 * @since 1 - 0
 * @param scan --> El scanner que te ayuda a obtener los valores del teclado
 * @param pila --> La lista de valores
 * @return Retorna la lista pero con valores dentro
 */
fun introducirUnNumero(scan : Scanner, pila : MutableList<Int>) : MutableList<Int> {
    var numero : Int
    val diez = 10
    val red = "\u001b[31m"
    val white = "\u001b[0m"
    var siONo = "S"

    while(siONo == "S"){
        numero = pedirNumerito("Digame el numero que quiere introducir: ", scan)
        scan.nextLine()

        if(pila.size <= diez){
            pila.add(numero)
        }
        else printlnMSG(red + "NO, eso no se puede, la pila esta llena" + white)

        siONo = leerLinea("Deseas seguir introduciendo numeros? [S/N]: ", scan).uppercase()
    }

    return pila
}

/**
 * La magnifica funcion main que te ayuda a organizar
 * @author Angel Sardinha
 * @since 1 - 0
 * @param pila --> La lista con o sin valores dentro
 * @return Retorna la lista menos el ultimo valor si es que tiene
 */
fun eliminarNumero(pila : MutableList<Int>) : MutableList<Int> {
    val red = "\u001b[31m"
    val white = "\u001b[0m"
    var tamanyo = pila.size

    try {
        mostrarUltimo(pila)
        pila.removeLast()
    }
    catch(e : Exception){
        printlnMSG(red + "Esto no se puede hacer, la pila esta vacia :(" + white)
    }

    return pila
}

/**
 * La magnifica funcion main que te ayuda a organizar
 * @author Angel Sardinha
 * @since 1 - 0
 * @param pila --> La lista
 */
fun mostrarUltimo(pila: MutableList<Int>){
    var ultimo : Int

        ultimo = pila.last()
        mostrarMensajeSinSalto("El numero que has eliminado es: $ultimo \n")
}

/**
 * La magnifica funcion main que te ayuda a organizar
 * @author Angel Sardinha
 * @since 1 - 0
 * @param pila --> La lista
 */
fun mostrarContenido(pila: MutableList<Int>) {
    mostrarMensajeSinSalto("Este es el contenido de la pila actualmente: $pila \n" )
}

/**
 * La magnifica funcion main que te ayuda a organizar
 * @author Angel Sardinha
 * @since 1 - 0
 */
fun main() {
    var scan = abrirScanner()

    var pila = definirPila()

    bucle(scan, pila)

    cerrarScanner(scan)
}