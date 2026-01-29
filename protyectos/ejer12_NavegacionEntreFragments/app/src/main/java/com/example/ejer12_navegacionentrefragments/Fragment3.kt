package com.example.ejer12_navegacionentrefragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.ejer12_navegacionentrefragments.databinding.Fragment3Binding

class Fragment3 : Fragment() {
    lateinit var binding: Fragment3Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment3Binding.inflate(inflater,container,false)
        binding.tvDatoRecibido.text = arguments?.getString("dato_enviar")// recivimos dato
        binding.bttRetroceder.setOnClickListener {
            findNavController().navigate(R.id.action_fragment3_to_fragment2)
        }
        return binding.root;
    }
}