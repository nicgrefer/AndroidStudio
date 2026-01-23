package com.example.ejem11_datosdefragmentaactivity

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ejem11_datosdefragmentaactivity.databinding.FragmentEnviarBinding

class FragmentEnviar : Fragment() {

    lateinit var binding: FragmentEnviarBinding

    lateinit var actividadPrincipal: ComunicandoFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEnviarBinding.inflate(inflater, container, false)

        binding.bttSend.setOnClickListener {
            actividadPrincipal.enviarDato(binding.tietDato.text.toString())
        }

        return binding.root
    }

    // Definimos una interfaz
    interface ComunicandoFragment {
        fun enviarDato(dato: String)
    }

    // Funcion que se ejecuta al crear el fragment el cual se comunica con el activity
    override fun onAttach(context: Context) {
        super.onAttach(context)
        actividadPrincipal = context as ComunicandoFragment
    }
}