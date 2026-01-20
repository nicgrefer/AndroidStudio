package com.example.ejemplo09_holafragment

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejemplo09_holafragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // En tiempo de ejecuion añadimos el fragment
        supportFragmentManager.beginTransaction().apply{
            add(R.id.fragmentDinamic, HolaFragment())
            commit()
        }
        // Cambiar gragment en tiempo de ejecucion al pulsar un boton
        binding.bttCambiarFragment.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentDinamic, HolaFragment2())
                addToBackStack(null) // Permitir volver al fragment anterior
                commit()
            }
        }

    }
}