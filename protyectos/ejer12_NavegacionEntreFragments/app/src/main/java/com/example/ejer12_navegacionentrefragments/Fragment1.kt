package com.example.ejer12_navegacionentrefragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.ejer12_navegacionentrefragments.databinding.Fragment1Binding

class Fragment1 : Fragment() {
    lateinit var binding: Fragment1Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment1Binding.inflate(inflater,container,false)
        binding.bttAvanzar.setOnClickListener {
            val datoEnviar: Bundle = Bundle()
            datoEnviar.putString("dato_enviar",binding.tietDatoAEnviar.text.toString())
            findNavController().navigate(R.id.action_fragment1_to_fragment2,datoEnviar)
        }
        return binding.root;
    }

}