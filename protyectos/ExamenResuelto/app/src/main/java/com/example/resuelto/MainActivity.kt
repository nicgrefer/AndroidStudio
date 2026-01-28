package com.example.resuelto

import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.resuelto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var posicionInicialX:Float=0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val persona:Persona = Persona("Pepe",18,"Madrid")
        binding.persona=persona // Para cargar los datos en el dataBinding al principio

        val listaPersonas = mutableListOf<Persona>()


        binding.tbEncender.setOnCheckedChangeListener { componente,isActivado ->
                binding.bGrabar.isEnabled= isActivado
         }
        val adapter = PersonaAdapter(listaPersonas)
        binding.rvDatos.adapter = adapter
        binding.rvDatos.layoutManager= LinearLayoutManager(this)



        binding.tvBorrar.setOnTouchListener { view, motionEvent ->
            when (motionEvent.action) {
                MotionEvent.ACTION_DOWN -> {
                    posicionInicialX = motionEvent.x
                }
                MotionEvent.ACTION_UP -> {
                    view.performClick()

                    if (Math.abs(posicionInicialX - motionEvent.x) > 200) {
                        listaPersonas.clear()
                        binding.etNombre.text.clear()
                        binding.etEdad.text.clear()
                        binding.rvDatos.adapter?.notifyDataSetChanged()
                    }
                }
            }
            true
        }

        binding.bGrabar.setOnClickListener {
            val persona : Persona = Persona(binding.etNombre.text.toString(),binding.etEdad.text.toString().toInt(),binding.sCiudades.selectedItem.toString())
            val dato: PersonaNombre by viewModels()
            dato.nombre=listaPersonas.lastOrNull().toString()


            Log.d("depurando",persona.toString())
            listaPersonas.add(persona)

            binding.rvDatos.adapter?.notifyDataSetChanged()

        }
      /*  binding.tvBorrar.setOnClickListener {
            listaPersonas.clear()
            binding.etNombre.text.clear()
            binding.etEdad.text.clear()
            binding.rvDatos.adapter?.notifyDataSetChanged()
        }*/



    }
}