package com.example.ejemploexamen2020

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.ejemploexamen2020.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity(){
    private lateinit var binding : ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.bInsertar.setOnClickListener {
            var pareja: Pareja = Pareja(
                binding.tvNombre1.toString(),
                binding.tvNombre2.toString(),
                binding.tietAntiguedad.text.toString().toInt()
            )

            intent.putExtra("pareja",pareja)
            setResult(RESULT_OK,intent)
            finish()

        }

    }
}