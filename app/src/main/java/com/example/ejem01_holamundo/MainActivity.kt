package com.example.ejem01_holamundo

import android.os.Bundle
import android.renderscript.ScriptGroup
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejem01_holamundo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // no es apropiado usar -> findViewById<>(R.id.b)
    // se usa View Binding
    // bindig : enlazar lo que es el código con lo que es el interfaz gráfica de manera directa
    // para activar el View Binding
    // abrimos el build.gradle (Module: app)
    // variable a nivel de clase llamada binding
    // como es una reerencia pero no esta creado y no sabemos si lo vamos a usar o no, hay que inicializarla con lateinit

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // con operador. nos salen los comoponentes de la interfaz gráfica
        // binding.b -> botón
        // damos a tvNombre el nombre de Paula
        //binding.tvNombre.text = "Paula";
        // usamos un lambda para el evento onClick cuando el interfaz solo tiene un metodo a desarrollar
        // el onclicklistener -> tiene el metodo onClick y se usa lambda para ello (lambda se ahorra codigo)
        binding.bSaludar.setOnClickListener {
            val user:Usuario = Usuario(binding.tieNombre.text.toString(),binding.tieEdad.text.toString().toInt())
            // al pulsar el botón, se ejecuta este código
            Log.d("depurando", "Hola " + user )
        }

        // creamos un data class
        }




    }
