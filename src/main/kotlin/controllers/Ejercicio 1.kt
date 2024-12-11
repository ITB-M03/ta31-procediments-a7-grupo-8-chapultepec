package controllers
import utilities.abrirScanner
import utilities.cerrarScanner
import utilities.printlnMSG
import java.time.LocalDate


/*enum class iva (val fechaInicio : LocalDate, val tipoGeneral: Double, val tipoReducid: Double, val tipoSuperReducido : Double, val tipoExemt :Double ) {
    milNueveOchoSeis(1992-1-1,0.12, 0.06, 0.0, 0.0),
    milNueveNueveDos(1 - 1 - 1986, 0.15, 0.06, 0.0, 0.0),
    milNueveNueveTres(1993, 0.12, 0.06, 0.03, 0.0),
    milNueveNueveCinco(1995, 0.16, 0.07, 0.04, 0.0 ),
    dosmilCeroUnoCero(2010, 0.18, 0.08, 0.04, 0.0),
    dosmilCeroUnoDos(2012, 0.21, 0.10, 0.04, 0.0)
}*/
/**
 * Funcion de inicio de codigo Iva
 * @author Iván Salamanca & Angel Sardinha
 */
fun main(){
    var scan = abrirScanner()
    printlnMSG("Hola Viajero del tiempo, Vamos a calcular el iva en cualquier moemto de la linea temporal")

    cerrarScanner(scan)
}
