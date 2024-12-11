import utilities.abrirScanner
import utilities.leerLinea
import utilities.pedirNumeritoDouble
import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * Estructura de datos para los periodos de IVA
 * @author Angel Sardinha e Ivan Salamanca
 * @since 1 - 0
 */
data class IVAPeriod(
    val fechaInicio: LocalDate,
    val general: Double,
    val reducido: Double,
    val superReducido: Double,
    val exento: Double
)

/**
 * Lista de periodos de IVA
 * @author Angel Sardinha e Ivan Salamanca
 * @since 1 - 0
 */
val periodosIVA = listOf(
    IVAPeriod(LocalDate.of(1986, 1, 1), 0.12, 0.06, 0.0, 0.0),
    IVAPeriod(LocalDate.of(1992, 1, 1), 0.15, 0.06, 0.0, 0.0),
    IVAPeriod(LocalDate.of(1993, 1, 1), 0.15, 0.07, 0.03, 0.0),
    IVAPeriod(LocalDate.of(1995, 1, 1), 0.16, 0.07, 0.04, 0.0),
    IVAPeriod(LocalDate.of(2010, 1, 1), 0.18, 0.08, 0.04, 0.0),
    IVAPeriod(LocalDate.of(2012, 7, 15), 0.21, 0.10, 0.04, 0.0)
)

/**
 * Función para obtener los porcentajes de IVA según la fecha
 * @author Angel Sardinha e Ivan Salamanca
 * @since 1 - 0
 * @param fechaCompra -> Esta es la fecha que ingresa el usuario
 * @return Retorna una posicion de la data class de periodos de iva
 */
fun obtenerIVAParaFecha(fechaCompra: LocalDate): IVAPeriod {
    return periodosIVA.last { it.fechaInicio <= fechaCompra }
}

/**
 * Función para calcular el IVA
 * @author Angel Sardinha e Ivan Salamanca
 * @since 1 - 0
 * @param precio -> El precio que indica el usuario
 * @param tipoIva -> El tipo de iva que se le aplica
 * @param fechaCompra -> Esta es la fecha que indica el usuario
 * @return Retorna el precio con el iva aplicado
 */
fun calcularIVA(precio: Double, tipoIVA: String, fechaCompra: LocalDate): Double {
    val periodoIVA = obtenerIVAParaFecha(fechaCompra)

    val porcentaje = when (tipoIVA) {
        "General" -> periodoIVA.general
        "Reducido" -> periodoIVA.reducido
        "Superreducido" -> periodoIVA.superReducido
        "Exento" -> periodoIVA.exento
        else -> {
            println("Tipo de IVA no válido: $tipoIVA. Se aplicará un IVA del 0%.")
            0.0 // Porcentaje por defecto si el tipo de IVA no es válido
        }
    }
    return precio + (precio * porcentaje)
}

/**
 * La magnifica fun main que es el maestro de la orquesta
 * @author Angel Sardinha e Ivan Salamanca
 * @since 1 - 0
 */
fun main() {
    var scan = abrirScanner()
    val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

    val precio = pedirNumeritoDouble("Introduce el precio: ",scan)
    scan.nextLine()

    val tipoIVA = leerLinea("Introduce el tipo de IVA (General, Reducido, Superreducido, Exento): ", scan)

    val fechaCompraStr = leerLinea("Introduce la fecha de compra (yyyy-MM-dd): ", scan)
    val fechaCompra = LocalDate.parse(fechaCompraStr, dateFormatter)

    val resultado = calcularIVA(precio, tipoIVA, fechaCompra)

    printFacturaIva(precio,fechaCompra,tipoIVA,resultado)
}

/**
 * La funcion que imprime la factura con todos los datos que se han utilizado
 * @author Angel Sardinha e Ivan Salamanca
 * @since 1 - 0
 * @param precio -> El precio al que se le aplica el IVA
 * @param fechaCompra -> La fecha en la que se realiza la compra
 * @param tipoIVA -> El tipo de IVA que se le aplica al precio
 * @param result -> El resultado del precio con el IVA aplicado
 */
fun printFacturaIva(precio: Double, fechaCompra: LocalDate, tipoIVA: String, result: Double) {
    println("""
*------------------SuFactura------------------*
* - Precio original:     $precio                   
* - Fecha de compra:     $fechaCompra
* - Tipo de IVA:         $tipoIVA
* - Precio con IVA:      $result
*---------------------------------------------*
    """.trimIndent())
}