package com.example.myapplication

// se emplea los : para heredar de una interfaz o clase abstracta (multiple y simultaria)
// Como el uso de herencia es peligrosa Kotlin lo tiene capado y hay que "activarla"
data class Persona(val nombre: String, var edad: Int, val soltero: Boolean, val email : String?) : SerHumano()
// si ponemos val es inmutable, si ponemos var es mutable
