package controllers
import utilities.*
import java.util.*


enum class iva (val fechaInicio : Int, val tipoGeneral: Double, val tipoReducid: Double, val tipoSuperReducido : Double, val tipoExemt :Double ) {
    milNueveOchoSeis(1986, 0.12, 0.06, 0.0, 0.0),
    milNueveNueveDos(1992, 0.15, 0.06, 0.0, 0.0),
    milNueveNueveTres(1993, 0.12, 0.06, 0.03, 0.0),
    milNueveNueveCinco(1995, 0.16, 0.07, 0.04, 0.0 ),
    dosmilCeroUnoCero(2010, 0.18, 0.08, 0.04, 0.0),
    dosmilCeroUnoDos(2012, 0.21, 0.10, 0.04, 0.0)
}
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

fun menu2(){}