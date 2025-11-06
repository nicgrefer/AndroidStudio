package com.example.myapplication
// es como un record en java
// permite crear directamente tu constructor
// para poner la herencia ponemos :SerHumano (usamos los dos puntos)
// se puede heredad de varias clase a la vez // herencia multiple simultanea
// al igual que con los nulos, para poder hacer lo de la herencia hay que poner en la clase SerHumano el open delanre de class
data class Persona(val nombre: String, var edad: Int, val email: String?) : SerHumano()
// la ? significa que puede ser nulo(edad)
// si ponemos val edad -> sus atributos no se pueden cambiar/ si lo cambiamos a var edad si que se puede

