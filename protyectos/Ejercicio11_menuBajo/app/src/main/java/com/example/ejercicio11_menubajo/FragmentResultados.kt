package com.example.ejercicio11_menubajo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ejercicio11_menubajo.databinding.FragmentResultadosBinding

class FragmentResultados : Fragment() {
    lateinit var binding: FragmentResultadosBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentResultadosBinding.inflate(inflater, container, false)
        return binding.root
    }

}