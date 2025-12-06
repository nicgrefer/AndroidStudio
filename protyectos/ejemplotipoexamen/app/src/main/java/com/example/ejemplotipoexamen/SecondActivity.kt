package com.example.ejemplotipoexamen

import android.content.Intent
import android.icu.text.AlphabeticIndex
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.ejemplotipoexamen.databinding.ActivitySegundoBinding
import com.google.android.material.snackbar.Snackbar


class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySegundoBinding
    private var zumos = mutableListOf<Zumo>();
    private var catalogo = arrayOf(
        Zumo("Naranja",1),
        Zumo("Pina",2),
        Zumo("Fresa",3),
        Zumo("Melocoton",4)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySegundoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNaranja.setOnClickListener {
            addZumo(0)
        }

        binding.btnPina.setOnClickListener {
            addZumo(1)
        }

        binding.btnFresa.setOnClickListener {
            addZumo(2)
        }

        binding.btnMelocoton.setOnClickListener {
            addZumo(3)
        }

        binding.btnFinalizar.setOnClickListener {
            Snackbar.make(binding.root,"Pedido cargado",Snackbar.LENGTH_SHORT).show()
            val resultIntent = Intent()
            resultIntent.putParcelableArrayListExtra("zumos", ArrayList(zumos))
            setResult(RESULT_OK,resultIntent)
            finish()
        }

    }

    private fun addZumo(index: Int){
        zumos.add(catalogo[index])
        Snackbar.make(binding.root,"${catalogo[index].nombre} agregado",Snackbar.LENGTH_SHORT).show()
    }

}