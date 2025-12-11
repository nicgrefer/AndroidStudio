package com.example.practicando001

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.practicando001.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.bttAdd.setOnClickListener {

            val nombre1 : String = binding.tietNombre1.text.toString()
            val nombre2 : String = binding.tietNombre2.text.toString()
            val duracion: Int = binding.tietDuracion.text.toString().toInt()

            val parejaNueva : Parejas = Parejas(nombre1,nombre2,duracion)

            Toast.makeText(this,"Pareja añadida: "+ parejaNueva, Toast.LENGTH_LONG).show()

            intent.putExtra("pareja",parejaNueva)
            setResult(RESULT_OK)
            finish()

        }

    }

}