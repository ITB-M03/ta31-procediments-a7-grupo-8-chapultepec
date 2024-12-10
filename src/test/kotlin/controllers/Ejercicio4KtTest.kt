package controllers

import org.example.controllers.guardarTamanyo
import org.example.controllers.inicioDeLaPalabra
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
 class Ejercicio4KtTest {

  /**
   * @author Angel Sardinha
   * @since 1 - 0
   */
  @Test
 fun guardarTamanyoTest() {
  var expected = 3
  assertEquals(expected, guardarTamanyo("FOL"))
  expected = 6
  assertEquals(expected, guardarTamanyo("Madres"))
  expected = 5
  assertEquals(expected, guardarTamanyo("Angel"))
 }
}