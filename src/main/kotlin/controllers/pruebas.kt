import utilities.abrirScanner
import utilities.leerLinea
import utilities.pedirNumeritoDouble
import java.time.LocalDate
import java.time.format.DateTimeFormatter

// Estructura de datos para los periodos de IVA
data class IVAPeriod(
    val fechaInicio: LocalDate,
    val general: Double,
    val reducido: Double,
    val superReducido: Double,
    val exento: Double
)

// Lista de periodos de IVA
val periodosIVA = listOf(
    IVAPeriod(LocalDate.of(1986, 1, 1), 0.12, 0.06, 0.0, 0.0),
    IVAPeriod(LocalDate.of(1992, 1, 1), 0.15, 0.06, 0.0, 0.0),
    IVAPeriod(LocalDate.of(1993, 1, 1), 0.15, 0.07, 0.03, 0.0),
    IVAPeriod(LocalDate.of(1995, 1, 1), 0.16, 0.07, 0.04, 0.0),
    IVAPeriod(LocalDate.of(2010, 1, 1), 0.18, 0.08, 0.04, 0.0),
    IVAPeriod(LocalDate.of(2012, 7, 15), 0.21, 0.10, 0.04, 0.0)
)

// Función para obtener los porcentajes de IVA según la fecha
fun obtenerIVAParaFecha(fechaCompra: LocalDate): IVAPeriod {
    return periodosIVA.last { it.fechaInicio <= fechaCompra }
}

// Función para calcular el IVA
fun calcularIVA(precio: Double, tipoIVA: String, fechaCompra: LocalDate): Double {
    val periodoIVA = obtenerIVAParaFecha(fechaCompra)

    // Selección del porcentaje según el tipo de IVA
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

    // Retornar el precio con IVA aplicado
    return precio + (precio * porcentaje)
}

fun main() {
    var scan = abrirScanner()
    val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

    // Pedir precio
    val precio = pedirNumeritoDouble("Introduce el precio: ",scan)

    // Pedir tipo de IVA
    scan.nextLine() // Limpiar buffer
    val tipoIVA = leerLinea("Introduce el tipo de IVA (General, Reducido, Superreducido, Exento): ", scan)

    // Pedir fecha de compra
    val fechaCompraStr = leerLinea("Introduce la fecha de compra (yyyy-MM-dd): ", scan)
    val fechaCompra = LocalDate.parse(fechaCompraStr, dateFormatter)

    // Calcular el precio con IVA
    val resultado = calcularIVA(precio, tipoIVA, fechaCompra)

    // Mostrar resultado
    printFacturaIva(precio,fechaCompra,tipoIVA,resultado)


}

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