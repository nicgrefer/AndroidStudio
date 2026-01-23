package com.example.ejem11_datosdefragmentaactivity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejem11_datosdefragmentaactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , FragmentEnviar.ComunicandoFragment  {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun enviarDato(dato: String) {
        binding.tvDato.text=dato
    }
}