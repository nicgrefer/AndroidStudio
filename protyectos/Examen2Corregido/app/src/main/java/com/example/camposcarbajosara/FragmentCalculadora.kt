package com.example.camposcarbajosara

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.room.Room
import com.example.camposcarbajosara.databinding.FragmentCalculadoraBinding

class FragmentCalculadora : Fragment() {

    lateinit var binding: FragmentCalculadoraBinding
    // para la interfaz
    lateinit var activityDependiente: EnviandoResultado
    // interfaz para pasar datos al main
    interface EnviandoResultado {
        fun enviarResultado(resultado: String)
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        activityDependiente = context as EnviandoResultado
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    var valorParcial: Int=0
    var resultado: Boolean=false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentCalculadoraBinding.inflate(inflater, container, false)

        // base de datos
        var baseDatos = Room.databaseBuilder(requireContext(), BD::class.java, "bdExamen").allowMainThreadQueries().build()
        var dao = baseDatos.resultadoDao()!!

        val botones = with(binding) {
            listOf(b0, b1, b2, b3, b4, b5, b6, b7, b8, b9)
        }

        botones.forEach { boton ->
            boton.setOnClickListener {
                if (binding.bResultado.text.toString() == "+")
                    binding.bResultado.text=""
                if (resultado) {
                    binding.bResultado.text=""
                    resultado=false
                    binding.bIgual.isEnabled=false
                }
                binding.bResultado.append(boton.text)
            }
        }

        binding.bSumar.setOnClickListener {
            valorParcial=binding.bResultado.text.toString().toInt()
            binding.bResultado.text="+"
            binding.bIgual.isEnabled=true
            binding.bSumar.isEnabled=false

        }
        binding.bIgual.setOnClickListener {
            Log.d("depurando",valorParcial.toString())
            var resultadoOperacion = (valorParcial+binding.bResultado.text.toString().toInt()).toString()
            binding.bResultado.text=resultadoOperacion

            // añadimos el resultado a la base de datos
            var resultadoParaHistorial = Resultado(resultado = resultadoOperacion)
            dao.insertar(resultadoParaHistorial)

            // pasamos el resultado al activity
            activityDependiente.enviarResultado(resultadoOperacion)

            resultado=true
            binding.bIgual.isEnabled=false
            binding.bSumar.isEnabled=true
        }


        return binding.root
    }
}