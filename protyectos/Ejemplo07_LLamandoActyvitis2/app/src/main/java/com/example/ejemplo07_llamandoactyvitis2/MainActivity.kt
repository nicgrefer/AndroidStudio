package com.example.ejemplo07_llamandoactyvitis2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ejemplo07_llamandoactyvitis2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bttEmail.setOnClickListener{
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_EMAIL,arrayOf("conijocus@gmail.com"))
            intent.putExtra(Intent.EXTRA_SUBJECT, "Asunto del email")
            intent.putExtra(Intent.EXTRA_TEXT, "Mensaje aquí")
            startActivity(intent)
        }

        binding.bttLlamar.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:123456789")
            startActivity(intent)
        }

        binding.bttWeb.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.google.com")
            startActivity(intent)
        }

        binding.bttMapa.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("geo:40.416775,-3.703790")
            startActivity(intent)
        }

        binding.bttWhasapp.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://wa.me/34123456789?text=Hola%20desde%20mi%20app")
            startActivity(intent)
        }

    }
}