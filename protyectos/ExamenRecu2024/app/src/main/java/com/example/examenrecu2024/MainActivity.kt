package com.example.examenrecu2024

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.examenrecu2024.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//var registro : ActivityResultLauncher<Intent> = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {  resultado ->
        var registro = registerForActivityResult (ActivityResultContracts.StartActivityForResult()) { resultado ->
            if (resultado.resultCode == RESULT_OK) {
                val persoanRecivida : Persona = resultado.data?.getParcelableExtra("persona_insertada",
                    Persona::class.java) as Persona
                Log.d("depurando", "Persona recibidda: ${persoanRecivida.nombre}, ${persoanRecivida.sexo}")
            }
        }

        binding.bAvanzar.setOnClickListener {
            var intent = Intent(this, MainActivity2::class.java)
            registro.launch(intent)
        }

    }
}