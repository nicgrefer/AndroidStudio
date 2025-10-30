package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /* cont + mayus + alt + insert
         enableEdgeToEdge()
         setContentView(R.layout.activity_main)
         ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
             val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
             v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
             insets
         }

         Log.d("depurando", "holamundo")

        */



        var numero = 3
        numero++
        Log.d("depurando", "el valor de numero es: $numero")

        var numero2 = 5
        numero2 = 6

        var cadena: String = "hola"
        Log.d("depurando", "el valor de cadena es: $cadena")

        var soltero: Boolean = true
        Log.d("depurando", "el valor de soltero es: $soltero")

        // Tipos primitivos: Int, String, Boolean, Float, Double, Char, Long, Short, Byte

        if (soltero) {
            Log.d("depurando", "estoy soltero")
        } else {
            Log.d("depurando", "no estoy soltero")
        }

        val resultado = if (numero > 2) {
            "es mayor que 2"
        } else {
            "es menor o igual que 2"
        }

        Log.d("depurando", "el resultado es: $resultado")

        var posibleNumero: String? = null
        if (posibleNumero.isNullOrEmpty()) {
            Log.d("depurando", "la cadena es nula o vacia")
        } else {
            Log.d("depurando", "la cadena tiene valor: $posibleNumero")
        }

        var edada = 18
        when (edada) {
            0,1,2 -> Log.d("depurando", "bebé")
            in 0..17 -> Log.d("depurando", "menor de edad")
            in 18..64 -> Log.d("depurando", "adulto")
            else -> Log.d("depurando", "tercera edad")
        }

        var fecha: String = "2025-10-30"
        when (fecha.substring(5,7)) {
            "01","02","03" -> Log.d("depurando", "primer trimestre")
            "04","05","06" -> Log.d("depurando", "segundo trimestre")
            "07","08","09" -> Log.d("depurando", "tercer trimestre")
            "10","11","12" -> Log.d("depurando", "cuarto trimestre")
            else -> Log.d("depurando", "mes no válido")

        }

        var estacion=when (fecha.substring(5,7)) {
            "12","01","02" -> "invierno"
            "03","04","05" -> "primavera"
            "06","07","08" -> "verano"
            "09","10","11" -> "otoño"
            else -> "mes no válido"
        }

        // Tipos de array

        var numerosArray: Array<Int> = arrayOf(1,2,3,4,5)
        var cadenasArray: Array<String> = arrayOf("hola","adios","hasta luego")
        var booleanosArray: Array<Boolean> = arrayOf(true, false, true)

            // Tambien te puedes crear arrays sin de cir el tipo
        var numerosArray2 = arrayOf(6,7,8,9,10)
            // Tambien se puede crear arrays de esta otra forma
        var arrayNumberos3 = intArrayOf(1,2,3,4,5)
        var charArray = charArrayOf('a','b','c','d')

        // Bucle
            //for
        for (num in numerosArray) {
            Log.d("depurando", "el valor del array es: $num")
        }

        for (i in cadenasArray.indices){
            Log.d("depurando", "el valor de la posicion $i es: ${cadenasArray[i]}")
        }

        for (j in 0..arrayNumberos3.size - 1){
            Log.d("depurando", "el valor de la posicion $j es: ${arrayNumberos3[j]}")
        }


        var i = 0
            //while
        while (i < booleanosArray.size) {
            Log.d("depurando", "el valor de la posicion $i es: ${booleanosArray[i]}")
            i++
        }
        i = 0
            //do while
        do {
            Log.d("depurando", "el valor de la posicion $i es: ${booleanosArray[i]}")
            i++
        } while (i < booleanosArray.size)

        // Array bidimensional
            // es un array que contiene arrays de ints
        var arrayBidimensional: Array<Array<Int>> = arrayOf(
            arrayOf(1,2,3),
            arrayOf(4,5,6),
            arrayOf(7,8,9)
        )

        for (arryIntero in arrayBidimensional) {
            for (num in arryIntero) {
                Log.d("depurando", "el valor del array bidimensional es: $num")
            }
        }

        // Colecciones:

        // Set -> No admite orden ni duplicados por eso solo se muestra una vez el 5
       var miString: Set <Int> = setOf(1,2,3,4,5,5,5)
        for (num in miString) {
            Log.d("depurando", "el valor del set es: $num")
        }

        // List -> Admite orden y duplicados
        var miLista: List<String> = listOf("rojo","verde","azul","amarillo")
        for (color in miLista) {
            Log.d("depurando", "el valor de la lista es: $color")
        }

        var miMapa: Map<String, String> = mapOf(
            "nombre" to "Juan",
            "apellido" to "Pérez",
            "edad" to "30"
        )

        for ((clave, valor) in miMapa) {
            Log.d("depurando", "la clave es: $clave y el valor es: ${miMapa[clave]} ")
        }

        Log.d ("depurando", "la suma es: ${sumar(3,5)}")

        val pepe = Persona ("Pepe", 25, true, "pepe@gemail.com")
        pepe.edad = 26
        Log.d("depurando", "el nombre es: ${pepe.nombre}, la edad es: ${pepe.edad}, ¿soltero?: ${pepe.soltero}, el email es: ${pepe.email}")

        var humano = SerHumano()


    }

    // Funciones
        // forma 1
    fun sumar(a: Int, b: Int): Int {
        return a + b
    }
        // forma 2
    fun sumar2(a: Int, b: Int) = a + b


}