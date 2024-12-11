package org.example.controllers
import utilities.*
import java.time.LocalDate


fun main() {
    val preu = 100.0
    val tipusIVA = "General"
    val dataCompra = LocalDate.of(2011, 6, 1)

    val resultat = calcularIVA(preu, tipusIVA, dataCompra)

    println("Preu original: $preu")
    println("Data de compra: $dataCompra")
    println("Tipus d'IVA: $tipusIVA")
    println("Preu amb IVA: $resultat")
}


// Estructura de dades per als períodes d'IVA
data class IVAPeriod(
    val startDate: LocalDate,
    val general: Double,
    val reduit: Double,
    val superReduit: Double,
    val exempt: Double
)

// Llista de períodes d'IVA
val ivaPeriods = listOf(
    IVAPeriod(LocalDate.of(1986, 1, 1), 0.12, 0.06, 0.0, 0.0),
    IVAPeriod(LocalDate.of(1992, 1, 1), 0.15, 0.06, 0.0, 0.0),
    IVAPeriod(LocalDate.of(1993, 1, 1), 0.16, 0.07, 0.04, 0.0),
    IVAPeriod(LocalDate.of(2010, 7, 1), 0.18, 0.08, 0.04, 0.0),
    IVAPeriod(LocalDate.of(2012, 9, 1), 0.21, 0.10, 0.04, 0.0)
)

// Funció per obtenir els percentatges d'IVA segons la data
fun getIVAForDate(dataCompra: LocalDate): IVAPeriod {
    return ivaPeriods.last { it.startDate <= dataCompra }
}

// Funció per calcular l'IVA
fun calcularIVA(preu: Double, tipusIVA: String, dataCompra: LocalDate): Double {
    val ivaPeriod = getIVAForDate(dataCompra)

    // Selecció del percentatge segons el tipus d'IVA
    val percentatge = when (tipusIVA) {
        "General" -> ivaPeriod.general
        "Reduït" -> ivaPeriod.reduit
        "Superreduït" -> ivaPeriod.superReduit
        "Exempt" -> ivaPeriod.exempt
        else -> throw IllegalArgumentException("Tipus d'IVA no vàlid: $tipusIVA")
    }

    // Retornar el preu amb IVA aplicat
    return preu + (preu * percentatge)
}

// Exemple d'ús
