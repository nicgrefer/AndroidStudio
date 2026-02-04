package com.example.ejer09_fragments

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.ejer09_fragments.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bttFr1.setOnClickListener {
            cargarFragment(Fragment1(),binding.tietDato.text.toString())
        }

    }
    private fun cargarFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fcv1,fragment)
            commit()
        }
    }
}