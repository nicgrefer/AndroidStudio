package com.example.ejem06_llamandoactivitys

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejem06_llamandoactivitys.databinding.ActivitySegundoBinding

class SegundoActivity : AppCompatActivity() {

    lateinit var binding: ActivitySegundoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivitySegundoBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val datoRecibido= intent.getStringExtra("DATO")
        binding.tvDatoRecibido.text=datoRecibido


    }
}