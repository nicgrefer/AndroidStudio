package com.example.ejercicio11_menubajo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ejercicio11_menubajo.databinding.FragmentParticipantesBinding

class FragmentParticipantes : Fragment() {
    lateinit var binding: FragmentParticipantesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentParticipantesBinding.inflate(inflater, container, false)
        return binding.root
    }
}