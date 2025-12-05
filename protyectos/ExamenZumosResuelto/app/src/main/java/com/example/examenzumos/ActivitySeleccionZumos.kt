package com.example.examenzumos

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.examenzumos.databinding.ActivitySeleccionZumosBinding
import com.google.android.material.snackbar.Snackbar

class ActivitySeleccionZumos : AppCompatActivity() {
    private lateinit var binding : ActivitySeleccionZumosBinding
    private var zumos = arrayListOf<Zumo>()
    private var catalogo = arrayOf(
        Zumo("Naranja",1),
        Zumo("Piña",2),
        Zumo("Fresa",3),
        Zumo("Melocoton",4))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySeleccionZumosBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnNaranja.setOnClickListener{
            agregarZumo(0)
        }

        binding.btnPina.setOnClickListener{
            agregarZumo(1)
        }

        binding.btnFresa.setOnClickListener{
            agregarZumo(2)
        }

        binding.btnMelocoton.setOnClickListener{
            agregarZumo(3)
        }

        binding.btnFinalizar.setOnClickListener{
            setResult(RESULT_OK,intent.putExtra("zumos",zumos))
            finish()
        }
    }

    private fun agregarZumo(index: Int){
        zumos.add(catalogo[index])
        Snackbar.make(binding.root,"${catalogo[index].nombre} agregado",Snackbar.LENGTH_SHORT).show()
    }
}