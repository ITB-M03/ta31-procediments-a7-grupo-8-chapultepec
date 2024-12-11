package controllers


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