package com.example.ejercicio10_fragment.ui.MostrarUsuario

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ejercicio10_fragment.R
import com.example.ejercicio10_fragment.databinding.FragmentListBinding

private  lateinit var binding: FragmentListBinding
class FragmentList : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

}