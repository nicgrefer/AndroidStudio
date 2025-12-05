package com.example.ejemplotipoexamen

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.ejemplotipoexamen.databinding.ActivityMainBinding
import com.example.ejemplotipoexamen.databinding.ActivitySegundoBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySegundoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySegundoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

    }
}