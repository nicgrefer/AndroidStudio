package com.example.ejer09_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ejer09_fragments.databinding.Fragment2Binding

class Fragment2 : Fragment() {

    lateinit var binding: Fragment2Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment2Binding.inflate(inflater,container,false)
        parentFragmentManager.setFragmentResultListener("dato",this){key,bundel ->
            val resultado = bundel.getString("dato")
            binding.tvDato.text = resultado
        }
        return binding.root
    }

}