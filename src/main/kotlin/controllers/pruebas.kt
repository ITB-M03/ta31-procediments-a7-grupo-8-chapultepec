import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd") // Formato de la fecha

    println("Introduce la fecha de compra en formato yyyy-MM-dd:")
    val fechaCompra: LocalDate

    try {
        val inputFecha = scanner.nextLine() // Leer la entrada como String
        fechaCompra = LocalDate.parse(inputFecha, dateFormatter) // Convertir a LocalDate
        println("La fecha introducida es: $fechaCompra")
    } catch (e: DateTimeParseException) {
        println("Formato de fecha incorrecto. Asegúrate de usar el formato yyyy-MM-dd.")
        return
    }

    // Ejemplo adicional con una operación
    val precio = 100.0
    val tipoIVA = "General"
    val resultado = calcularIVA(precio, tipoIVA, fechaCompra)

    println("Precio original: $precio")
    println("Fecha de compra: $fechaCompra")
    println("Tipo de IVA: $tipoIVA")
    println("Precio con IVA: $resultado")
}

// Aquí irían las demás funciones como calcularIVA y obtenerIVAParaFecha
fun calcularIVA(precio: Double, tipoIVA: String, fechaCompra: LocalDate): Double {
    // Aquí suponiendo una implementación de prueba
    return precio * 1.21 // Simula un IVA del 21%
}