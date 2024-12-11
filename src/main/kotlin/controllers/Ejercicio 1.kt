package controllers
import utilities.*
import java.util.*

/**
 * Funcion de inicio de codigo Iva
 * @author Iván Salamanca & Angel Sardinha
 */
fun main(){

}





















































fun menu1(scan : Scanner) : Int {
    var opcion : Int

    mostrarMensajeSinSalto("""
        ----------------------------------------
                  Buenas tardes :3
        Opcion 1: 1986
        Opcion 2: 1992
        Opcion 3: 1993
        Opcion 4: 1995
        Opcion 5: 2010
        Opcion 6: 2012 (Antes del 15 de Julio)
        Opcion 7: 2012 (Despues del 15 de Julio)
        Opcion 8: Salir
        -----------------------------------------
    """.trimIndent())
    opcion = pedirNumerito("Buenas, me gustaria que me dijeses de que año quieres aplicar el IVA, Introduce el número de tu opcion: ", scan)

    return opcion
}

fun menu2(scan : Scanner, )