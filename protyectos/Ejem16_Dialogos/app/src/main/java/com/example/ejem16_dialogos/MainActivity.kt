package com.example.ejem16_dialogos

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejem16_dialogos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bttConfirmacion.setOnClickListener {
            val dialogo: AlertDialog.Builder = AlertDialog.Builder(this)
            dialogo.setTitle("Estas seguro")
            dialogo.setMessage("Este es el cuerpo del mensaje")
            dialogo.setPositiveButton ("Si") { dialogoInterfaz, i ->
                Toast.makeText(this,"Has pulsado si",Toast.LENGTH_SHORT).show()
            }
            dialogo.setNegativeButton ("No") { dialogoInterfaz, i ->
                Toast.makeText(this, "Has pulsado no", Toast.LENGTH_SHORT).show()
            }
            dialogo.show()
        }
        binding.bttSelectorMultiple.setOnClickListener {
            val opciones = arrayOf("Opcion 1", "Opcion 2", "Opcion 3")

            val dialogo: AlertDialog.Builder = AlertDialog.Builder(this)
            dialogo.setTitle("Estas seguro")
            dialogo.setItems (opciones) { dialogoInterfaz, i ->
                Toast.makeText(this,"Has pulsado ${opciones[i]}",Toast.LENGTH_SHORT).show()
            }
            dialogo.show()
        }

        binding.bttSelectonesMultiples.setOnClickListener {
            val opciones = arrayOf("Opción 1", "Opción 2", "Opción 3","Opción 4")
            val opcionesSeleccionadas = booleanArrayOf(false, true, false, false)
            val dialogo: AlertDialog.Builder= AlertDialog.Builder(this)
            dialogo.setMultiChoiceItems(opciones,opcionesSeleccionadas) { dialogInterface, i, b ->
            }
            dialogo.setTitle("Selecciona varias opciones")
            dialogo.setPositiveButton("Aceptar") { dialogInterface, i ->
                for (opcion in opciones.indices) {
                    if (opcionesSeleccionadas[opcion]) {
                        Toast.makeText(this, "Has seleccionado ${opciones[opcion]}", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            dialogo.show()

        }

    }
}