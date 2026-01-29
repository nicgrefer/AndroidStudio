package com.example.ejer12_navegacionentrefragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.ejer12_navegacionentrefragments.databinding.Fragment2Binding

class Fragment2 : Fragment() {
    lateinit var binding: Fragment2Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment2Binding.inflate(inflater,container,false)
        binding.tvDatoRecibido.text = arguments?.getString("dato_enviar")// recivimos dato
        // Preparamos el envio de dato
        val datoRecibido = arguments?.getString("dato_enviar")
        binding.bttAvanzar.setOnClickListener {
            val datoEnviar: Bundle = Bundle()
            datoEnviar.putString("dato_enviar",binding.tietDatoAEnviar.text.toString())
            findNavController().navigate(R.id.action_fragment2_to_fragment3,datoEnviar)

        }
        binding.bttRetroceder.setOnClickListener {
            findNavController().navigate(R.id.action_fragment2_to_fragment1)
        }
        return binding.root;
    }
}