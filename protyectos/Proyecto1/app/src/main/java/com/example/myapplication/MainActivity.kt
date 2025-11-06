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

        /*enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/

        Log.d("depurando", "holamundo") // sacar por consola
        // creacion de variables
        var numero = 3
        numero++
        Log.d("depurando", "el numero es $numero")

        val cadena:String="Hola" // primero ponemos el nombre y despues el tipo de dato
        Log.d("depurando", "la cadena es $cadena")

        var soltero:Boolean = true

        Log.d("depurando", "soltero = $soltero")
        // Tipos primitivos: int, byte, short, long, float, double, char, boolean
        // Estructuras de control basicas
        // si es una linea no hace falta poner llaves {} -> if (condicion) instruccion
        if(soltero && numero>2) // si es soltero y numero >2 muestra lo de abajo
            Log.d("depurando", "estoy soltero")
        // log.d -> depuracion
        // log.e -> errores
        else // si no lo es
            Log.d("depurando", "no estoy soltero")

        // dar con un if un valor a una variable
        var resultado = if(numero>2) "es mayor" else "es menor"
        Log.d("depurando", "el resultado = $resultado")

        // errores nullpointException -> no hay valor (hay un texto y no han añadido nada)
        // no permite trabajar alegremente con nulos
        // si quieres quetenga valor nulo tienes que indicarlo tu
        var posibleNulo:String?= null // puede tener elvalor nulo (?)
        // hay varios metodos para trabajar con nulos
        if(posibleNulo.isNullOrBlank()) // si es nulo o esta vacia
            Log.d("depurando", "la cadena es nulo o vacia")

        var edad=18
        when(edad){ // switch se pone when en kotlin // el break lo hace solo
            0,1,2 -> Log.d("depurando", "eres un bebe") // varios valores aislados separadas por coma
            in 3..12 -> Log.d("depurando", "eres un niño") // opciones grupales -> son rangos realmene se escribe in 3 .. 12 // el menos igual lo pone ello solo
            in 13..19 -> Log.d("depurando", "eres un adolescente")
            else -> Log.d("depurando", "eres un adulto")
        }

        var fecha: String = "2024-06-15" // formato AAAA-MM-DD
        when (fecha.substring(5,7).toInt()){ // extrae el mes de la fecha (substring) y lo convierte a entero (toInt)
            1,2,12 -> Log.d("depurando", "invierno")
            3,4,5 -> Log.d("depurando", "primavera")
            6,7,8 -> Log.d("depurando", "verano")
            9,10,11 -> Log.d("depurando", "otoño")
            else -> Log.d("depurando", "mes incorrecto")

        }
        // usar cadenas de texto en vez de enteros
        var fecha2: String = "2024-06-15"
        when (fecha2.substring(5,7)) {
            // usar cadenas de texto
            "01", "02", "03" -> Log.d("depurando", "invierno")
            "04", "05", "06" -> Log.d("depurando", "primavera")
            else -> Log.d("depurando", "otra estacion")
        }
        // actua como una funcion que devuelve un valor igual que el if
        var estacion = when (fecha2.substring(5,7)) {
            "01", "02", "03" -> "invierno"
            "04", "05", "06" -> "primavera"
            else -> "otra estacion"
        }

        // Tipos de arrays.
        var arrayEnteros: Array<Int> = arrayOf(1,2,3,4,5)
        var arrayCadenas: Array<String> = arrayOf("uno","dos","tres")
        var arrayBooleanos: Array<Boolean> = arrayOf(true, false, true)
        // no es obligatorio poner el tipo de dato
        var arrayEnteros2 =   arrayOf(1,2,3,4,5)

        // hay mas opciones para crear arrays
        val arrayNumeros3= intArrayOf(1,2,3,4,5) // array de enteros2
        val arrayCaracteres = charArrayOf('a','b','c') // array de caracteres

        // Bucles
        for (numero in arrayEnteros){ // recorre el array // si tenemos la variable arriba y la volvemos a usar aqui se sobreescribe
            Log.d("depurando", "numero = $numero") // muestra cada numero
        }
        // indica cada indice que tiene el array (a el no le gusta esta forma)
        for (i in arrayCadenas.indices){ // recorre el array por indices
            Log.d("depurando", "cadena en indice $i = ${arrayCadenas[i]}") // muestra cada cadena con su indice
        }
        // rango de 0 al tamaño del arrayCadenas -1
        for(j in 0 .. arrayCadenas.size-1){ // recorre el array por indices (otra forma)
            Log.d("depurando", "cadena en indice $j = ${arrayCadenas[j]}") // muestra cada cadena con su indice
            // meter dentro valores de variables ${variable}
            Log.d("depurando","cadena en indice $j =  + ${arrayCadenas.get(j)}") // otra forma de hacerlo
        }

        // Bucle while
        // hacer un contador normal
        var i = 0
        while (i < arrayCadenas.size){ // mientras indice sea menor que el tamaño del array
            Log.d("depurando", "cadena en indice $i = ${arrayCadenas[i]}") // muestra cada cadena con su indice
            i++ // incrementa el indice
        }

        i=0
        // hace un bucle do while
        do{
            Log.d("depurando", "cadena en indice $i = ${arrayCadenas[i]}") // muestra cada cadena con su indice
            i++ // incrementa el indice
        } while (i<arrayCadenas.size)

        // ArrayBidimensional // matriz
        val arrayBidimensional: Array<Array<Int>> = arrayOf(
            arrayOf(1,2,3),
            arrayOf(4,5,6),
            arrayOf(7,8,9)
        )
        for (arrayInterno in arrayBidimensional){
            for(elemento in arrayInterno){
                Log.d("depurando", "elemento = $elemento")
            }
        }

        // Colecciones
        // los set no permiten valores dublicados// no da error pero no ls almacena // no tiene un orden
        val miSet:Set<Int> = setOf(1,2,3,4,5,5,5)
        for (variable in miSet){
            Log.d("depuraciando", "set elemento = $variable")
        }
        // lal ista no es de un valor determinado y admite duplicados
        val miLista:List<String> = listOf("uno","dos","tres","cuatro")
        for (variable in miLista){
            Log.d("depuraciando", "lista elemento = $variable")
        }
        // el mapa tiene unaclave asciada a un valor
        val miMapa:Map<String,Int> = mapOf("Uno" to 1, "dos" to 2, "tres" to 3)
        // las keys son uno,dos,tres
        for (clave in miMapa.keys){
            // las coge y muestra mi mapa uno,dos,tres
            Log.d("depuraciando", "mapa elemento = $clave, valor = ${miMapa[clave]}")
        }

        // llamar sumar desde aqui
        Log.d("depurando", "La suma es ${sumar(3,4)}")

        // Despues de crear la clase persona
        val pepe = Persona("Pepe", 30, "a@b.com")
        pepe.edad=33
        Log.d("depurando", "la edad de ${pepe.nombre} es ${pepe.edad}")

        // Despues de crear la clase SerHumano
        val hombre = SerHumano() // aqui vemos que como se lo hemos dado antes por defecto no hace falta ponerle valores aqui


    }
    // no estamos poniendo como son los atributos pero si que se puede poner
    fun sumar(a: Int, b: Int) : Int{
        return a + b
    }
    fun sumar2(a : Int, b: Int) = a + b
}