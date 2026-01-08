package com.example.examenrecu2024

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.examenrecu2024.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bAnadir.setOnClickListener {

            var sexo = ""

            if (binding.rbHombre.isChecked) {
                sexo = "Hombre"
            } else if (binding.rbMujer.isChecked) {
                sexo = "Mujer"
            }

            val persona = Persona(
                binding.etNombre.text.toString(),
                sexo
            )

            val intentResultado = Intent()
            intentResultado.putExtra("persona_insertada", persona)

            setResult(RESULT_OK, intentResultado)
            finish()
        }
    }
}
