package com.example.ejemplotipoexamen

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejemplotipoexamen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var zumos = mutableListOf<Zumo>()
    private lateinit var adapter: ArrayAdapter<Zumo>

    private var launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { resultado ->
        if (resultado.resultCode == RESULT_OK){
            val nuevosZumos = if (Build.VERSION.SDK)

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Cargamos datos predefinidos
        val userPredefinido = User("palo_valdes", "1234")
        binding.tietUsuario.setText(userPredefinido.user)
        binding.tietCode.setText(userPredefinido.pass)
        binding.imgLogo.setImageResource(R.drawable.logo_marca)


        binding.bttLogin.setOnClickListener {
            // Limpiar errores previos
            binding.tilUsuario.error = null
            binding.tilCode.error = null

            // Obtener valores
            val user = binding.tietUsuario.text.toString()
            val pass = binding.tietCode.text.toString()
            var datosCorrectos = true

            // Validar usuario
            if (user != userPredefinido.user) {
                binding.tilUsuario.error = "Usuario incorrecto"
                datosCorrectos = false
            }

            // Validar contraseña
            if (pass != userPredefinido.pass) {
                binding.tilCode.error = "Contraseña incorrecta"
                datosCorrectos = false
            }

            if (datosCorrectos) {
                val intent = Intent(this, SecondActivity::class.java)
                launcher.launch(intent)
            }
        }
    }
}