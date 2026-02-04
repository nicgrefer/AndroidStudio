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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bttFr1.setOnClickListener {
            cargarFragment(Fragment1())
        }

    }
    private fun cargarFragment(fragment: Fragment){
        val bundle = Bundle().apply {
            putString("dato", binding.tietDato.text.toString())
        }
        fragment.arguments = bundle
        supportFragmentManager.beginTransaction().apply {
            add(R.id.fcv1, fragment)
            commit()
        }
    }
}