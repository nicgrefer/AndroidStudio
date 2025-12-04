package com.example.ejemplotipoexamen

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejemplotipoexamen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

        var userPredefinido: User = User("palo_valdes", "1234")
        binding.tietUsuario.setText(userPredefinido.user)
        binding.tietCode.setText(userPredefinido.pass)
        binding.imgLogo.setImageResource(R.drawable.logo_marca)



    }
}