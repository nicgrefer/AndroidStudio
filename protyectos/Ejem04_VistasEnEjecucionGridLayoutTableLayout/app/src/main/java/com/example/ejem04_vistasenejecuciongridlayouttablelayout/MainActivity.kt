package com.example.ejem04_vistasenejecuciongridlayouttablelayout

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.ejem04_vistasenejecuciongridlayouttablelayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val boton1 = Button(this)
        boton1.text = "Botón creado en ejecución"

        // IMPORTANTE: usar el ID correcto del GridLayout
        binding.llHorizontal.addView(boton1)
    }
}
