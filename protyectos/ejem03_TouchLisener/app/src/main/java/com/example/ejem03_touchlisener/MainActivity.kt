package com.example.ejem03_touchlisener

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejem03_touchlisener.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Toast.makeText(this,"Actividad creada",Toast.LENGTH_SHORT).show()
        Snackbar.make(binding.llFondo,"Actividad creada",Snackbar.LENGTH_SHORT).show()


        var valorXInicial = 0f
        var valorXFinal = 0f

        binding.llFondo.setOnTouchListener { view, evento ->
            Log.d("depurando", "TOCADO EN EL FONDO")

            when (evento.action) {

                android.view.MotionEvent.ACTION_DOWN -> {
                    valorXInicial = evento.x
                }

                android.view.MotionEvent.ACTION_UP -> {
                    valorXFinal = evento.x

                    val diferencia = valorXFinal - valorXInicial  // Aquí ya puede ser negativa

                    Snackbar.make(view, "Swipe: $diferencia px", Snackbar.LENGTH_SHORT).show()
                    Toast.makeText(this, "Swipe: $diferencia px", Toast.LENGTH_SHORT).show()
                    Log.d("depurando", "Swipe: $diferencia px")
                }
            }

            true
        }

        // donde estas pulsando, toda la informacion que da el evento (pulsacion, movimiento, etc)
        binding.llFrontal.setOnTouchListener { view, evento ->
            Log.d("depurando", "TOCADO EN EL FRONTAL")
            // al poner false, se propaga el evento al fondo por detras del frontal esta el fondo (el padre recibe tambien el evento)

            false
        }


    }
}