package com.example.ejemplo09_holafragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ejemplo09_holafragment.databinding.FragmentHola2Binding

class HolaFragment2 : Fragment() {

    lateinit var binding: FragmentHola2Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHola2Binding.inflate(inflater, container, false)

        parentFragmentManager.setFragmentResultListener ( "dato", this,{ key, bundle ->
            val resultado = bundle.getString("saludo")
            binding.tvSaludo.text = resultado
        } )

        return binding.root
    }

}