package org.example.controllers
import utilities.*
import javax.swing.text.StyledEditorKit.BoldAction


var intentos = 0
var encontrada = false

/**
 * Codigo Principal Ejecutable
 * @author Iván Salamanca
 */
fun main (){
    // Contraseña
    val superUserPass = "IoSonoSudo"
    var scan = abrirScanner()
    printlnMSG("Para Continuar Necesitare que intpodizcas la contraseña de SUDO")
    printlnMSG("Tienes 3 Intentos")
    while (intentos < 3 ) {
        // Intro Contraseña
        var passW = leerLinea("user@MacBook-Pro-de-user ~ %: ", scan)
        // Comparar contraseñas y check intentos
        var result = chekPassw(passW, superUserPass)
        resultchekPassw(result)
    }
}

/**
 * Analizar contraseña introducida
 * @author Iván Salamanca
 * @param passW Contraseña intpducida
 * @param superUserPass contraseña correcta de sudo
 * @return si la contraseña introduccida es correcta o no
 */
fun chekPassw(passW : String, superUserPass : String) : Boolean {
    var result : Boolean
    if (passW == superUserPass && intentos < 3){
        result = true
    } else {
        result = false
        intentos ++
    }
    return result
}

/**
 * muestra el resultado de la comparazion al usuario
 * @author Iván Salamanca
 * @param result resultado de la comparacion
 */
fun resultchekPassw(result: Boolean) {
    if (intentos < 3 && result == true){
        println("Contraseña correcta")
        intentos = 3
    } else if (intentos < 3 && result == false) {
        println("Contraseña incorrecta")
        println("Intentos restantes: "+ (3- intentos))
    } else println("No mas intentos restantes")
}


