package com.example.ejer7_fragmentstipoexamen

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejer7_fragmentstipoexamen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), FragmentIncremento.ComunicandoFragment {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun sumar(numActual: Int) {
        binding.tvContador.text = numActual.toString()
    }
}