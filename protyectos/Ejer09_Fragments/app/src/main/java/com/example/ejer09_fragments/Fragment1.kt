package com.example.ejer09_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ejer09_fragments.databinding.Fragment1Binding

private const val arg_dato = "dato"

class Fragment1 : Fragment() {

    private var dato: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            dato = it.getString(arg_dato)
        }
    }

    lateinit var binding: Fragment1Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment1Binding.inflate(inflater,container,false)
        binding.tvMostrarDato.text = dato
        binding.button.setOnClickListener {
            val parametro : Bundle = Bundle()
            parametro.putString("dato",binding.tietDato.text.toString())
            parentFragmentManager.setFragmentResult("dato",parametro)
        }
        return binding.root
    }


}