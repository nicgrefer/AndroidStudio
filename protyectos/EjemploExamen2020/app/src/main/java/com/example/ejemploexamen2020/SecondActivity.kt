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



    }
}