package com.example.ejemplo09_holafragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ejemplo09_holafragment.databinding.FragmentHolaBinding


class HolaFragment : Fragment() {

    lateinit var binding: FragmentHolaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHolaBinding.inflate(inflater, container, false)
        binding.bttSaludo.setOnClickListener {
            binding.tvSaludo.text="Hola Soy fragment"
        }

        binding.bttSend.setOnClickListener { 
            binding.tvSaludo.text = "¡Hola fragment!"
            val dato: Bundle= Bundle() // Objeto qe puede guardar cualquier dato
            dato.putString("saludo", binding.tietDato.text.toString()) // Guardamos el dato con identificador "saludo" (en este caso un string)
            parentFragmentManager.setFragmentResult("dato", dato) // Enviamos el dato al fragment2
            // Cambiar automáticamente al fragment2 para mostrar el dato
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentDinamic, HolaFragment2())
                addToBackStack(null)
                commit()
            }
        }

        return  binding.root
    }

}