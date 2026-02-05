package com.example.ejem14_persistencia

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejem14_persistencia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val datoGuardado = getSharedPreferences("MisDatos",MODE_PRIVATE)
        binding.tvDato.text = datoGuardado.getString("datoGuardado","No hay dato guardado")

        binding.bttGuardar.setOnClickListener {
            val dato = binding.tietDato.text.toString()// cogemos el dato
            val sharedPreferences = getSharedPreferences("MisDatos",MODE_PRIVATE)// Creamos un fichero para guardar
            val editor = sharedPreferences.edit() // Creamos un editor para guardar los datos
            editor.putString("datoGuardado",dato)// guardamos el dato
            editor.apply() // aplicamos los cambios
        }

    }
}