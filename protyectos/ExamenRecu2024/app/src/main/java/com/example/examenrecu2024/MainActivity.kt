package com.example.examenrecu2024

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examenrecu2024.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textview.MaterialTextView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val lista = mutableListOf<Persona>()
        lista.add(Persona("Pepe"))
        lista.add(Persona("Amara","Mujer"))

        var registro = registerForActivityResult (ActivityResultContracts.StartActivityForResult()) { resultado ->
            if (resultado.resultCode == RESULT_OK) {
                val persoanRecivida: Persona = resultado.data?.getParcelableExtra(
                    "persona_insertada",
                    Persona::class.java
                ) as Persona
                Log.d(
                    "depurando",
                    "Persona recibidda: ${persoanRecivida.nombre}, ${persoanRecivida.sexo}"
                )
                lista.add(persoanRecivida)
                binding.rvPersonas.adapter?.notifyDataSetChanged()
            }
        }

        val adapter = PersonaAdapter(lista)
        binding.rvPersonas.adapter = adapter
        binding.rvPersonas.layoutManager = LinearLayoutManager(this)

        binding.bAvanzar.setOnClickListener {
            var intent = Intent(this, MainActivity2::class.java)
            registro.launch(intent)
        }

        binding.lvDatos.adapter = ArrayAdapter<Persona> (this,android.R.layout.simple_list_item_1,lista)
        binding.lvDatos.onItemClickListener = AdapterView.OnItemClickListener{adaptador, vista, posicion, identificador ->
                val prsonaPulsada : Persona = lista.get(posicion)
                Toast.makeText(this,(vista as MaterialTextView).text.toString(),Toast.LENGTH_SHORT).show()
                Snackbar.make(binding.root,prsonaPulsada.sexo, Snackbar.LENGTH_SHORT).show()
            }

    }
}