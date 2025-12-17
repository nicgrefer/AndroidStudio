package com.example.ejem08_viewmodels

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejem08_viewmodels.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val contadorViewModel : Contador by viewModels()
        binding.lifecycleOwner=this
        binding.cont=contadorViewModel

        val cNormal : ContadorNormal = ContadorNormal();
        binding.bIncrementar.setOnClickListener {
            contadorViewModel.increment()
            binding.cont = contadorViewModel
            cNormal.incrementar()
            binding.contNormal = cNormal
        }

    }
}