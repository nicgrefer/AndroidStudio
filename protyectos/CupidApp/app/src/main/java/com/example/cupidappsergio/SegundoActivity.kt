package com.example.cupidappsergio

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.cupidappsergio.databinding.ActivitySegundoBinding

class SegundoActivity : AppCompatActivity() {
    lateinit var binding: ActivitySegundoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySegundoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bInsertar.setOnClickListener {
/*            var nombre1= binding.tietPersona1.text.toString()
            var nombre2= binding.tietPersona2.text.toString()
            var antiguedad =  binding.tietAntiguedad.text.toString().toInt()

            var pareja : Pareja = Pareja(nombre1,nombre2,antiguedad)*/
            val pareja=binding.pareja
            Log.d("depurando", "Pareja creada: $pareja")

            intent.putExtra("PAREJA_DEVUELTA", pareja)

            setResult(RESULT_OK, intent)
            finish()

        }
    }
}