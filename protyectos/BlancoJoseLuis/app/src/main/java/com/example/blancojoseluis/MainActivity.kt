package com.example.blancojoseluis

import android.os.Bundle
import android.view.MotionEvent
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.blancojoseluis.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(binding.tbEncender.isEnabled){
            binding.bGrabar.isActivated == false
        }

        val listaPersona: MutableList<Persona>

        var nombre by viewModels()

        binding.bGrabar.setOnClickListener {
            Toast.makeText(this, binding.etEdad.text.toString(), Toast.LENGTH_SHORT).show()
            nombre = binding.etNombre.text.toString()
            listaPersona.add(Persona(binding.etNombre.text.toString(), binding.etEdad.text.toString()))
            binding.rvUsuarios.adapter = PersonaAdapter
            binding.rvUsuarios.layoutManager =
        }

        binding.tvBorrar.setOnHoverListener { (view, MotionEvent) ->
            if()
        }
    }
}