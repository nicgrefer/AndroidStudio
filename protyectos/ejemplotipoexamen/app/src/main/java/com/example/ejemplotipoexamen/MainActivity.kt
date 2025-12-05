package com.example.ejemplotipoexamen

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejemplotipoexamen.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

        // Cargamos datos predefinidos
        var userPredefinido: User = User("palo_valdes", "1234")
        binding.tietUsuario.setText(userPredefinido.user)
        binding.tietCode.setText(userPredefinido.pass)
        binding.imgLogo.setImageResource(R.drawable.logo_marca)

        binding.bttLogin.setOnClickListener(){
            // Comprobacon usuario correcto
            var user:String = binding.tietUsuario.text.toString()
            var pass:String = binding.tietCode.text.toString()
            var datosCorrectos:Boolean = false

            if (user != userPredefinido.user){
                binding.tilUsuario.error = "Usuario incorrecto"
                datosCorrectos= false
            }
            if (pass != userPredefinido.pass){
                binding.tilCode.error = "Contraseña incorrecta"
                datosCorrectos= false
            }
            if (user == userPredefinido.user && pass == userPredefinido.pass){
                datosCorrectos= true
            }

            if (datosCorrectos){
                Intent(this, SecondActivity::class.java).also {
                    startActivity(it)
                }
            }
        }


    }
}

