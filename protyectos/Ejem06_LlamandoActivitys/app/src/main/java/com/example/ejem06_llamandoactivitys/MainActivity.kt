package com.example.ejem06_llamandoactivitys

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ejem06_llamandoactivitys.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bLogIn.setOnClickListener {
            val nombre = binding.tietNombre.text?.toString()?.trim().orEmpty()
            val edadStr = binding.tietEdad.text?.toString()?.trim().orEmpty()
            val correo = binding.tietCorreo.text?.toString()?.trim().orEmpty()

            if (nombre.isEmpty() || edadStr.isEmpty() || correo.isEmpty()) {
                Toast.makeText(this, "Rellena todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val edad = edadStr.toIntOrNull()
            if (edad == null) {
                Toast.makeText(this, "Edad no válida", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val usuario = Usuario(nombre = nombre, edad = edad, email = correo)
            val intent = Intent(this, SegundoActivity::class.java).apply {
                putExtra("usuario", usuario)
            }
            startActivity(intent)
        }
    }
}