package utilities

import java.util.*

/**
 *Apertura de Scanner
 * @author Angel Sardinha
 * @return Devuelve el scanner para usarlo en el resto del programa
 */
fun abrirScanner() : Scanner {
    var scan = Scanner(System.`in`)

    return scan
}

/**
 *Cierre del Scanner
 * @author Angel Sardinha
 * @param scan --> la funcion que contiene el scanner
 */
fun cerrarScanner(scan : Scanner) {
    scan.close()
}

/**
 * Lectura de la Linea
 * @author Angel Sardinha
 * @param msg --> Mensaje para indicar al usuario que hacer
 * @param scan --> Funccion de scanner
 */
fun leerLinea(msg : String, scan : Scanner) : String {
    print(msg)
    var titulo = scan.nextLine()

    return titulo
}