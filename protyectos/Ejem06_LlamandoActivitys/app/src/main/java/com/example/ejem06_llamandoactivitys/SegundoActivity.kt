package com.example.ejem06_llamandoactivitys

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.ejem06_llamandoactivitys.databinding.ActivitySegundoBinding

class SegundoActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySegundoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySegundoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // leer de forma compatible con distintas API
        val datoRecibido: Usuario? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("DATO", Usuario::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("DATO") as? Usuario
        }

        val usuario: Usuario? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("usuario", Usuario::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("usuario") as? Usuario
        }

        if (usuario == null && datoRecibido == null) {
            Log.e("SegundoActivity", "No se recibió usuario en el Intent (claves probadas: \"usuario\",\"DATO\"). Cerrando actividad.")
            finish()
            return
        }

        // mostrar datos (prioriza `usuario`, si no existe usa `datoRecibido`)
        val mostrar = usuario ?: datoRecibido!!
        binding.tvMuestroLogin.text = mostrar.toString()
        binding.tvDatoRecibido.text = datoRecibido?.toString() ?: ""

        binding.bDevolver.setOnClickListener {
            val datoDevolver = binding.tietDatoDevuelto.text.toString()
            Log.d("SegundoActivity", "Dato a devolver: $datoDevolver")

            val resultIntent = Intent().apply {
                putExtra("dato_devuelto", datoDevolver)
            }
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}
