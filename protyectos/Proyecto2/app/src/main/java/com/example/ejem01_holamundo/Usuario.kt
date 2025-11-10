package com.example.ejem01_holamundo

data class Usuario(val nombre: String, val edad: Int, var soltero: Boolean = false, var ciudad: String = "Desconocida", var colorFab : String = " ") {
    override fun toString(): String {
        return nombre
    }
}
