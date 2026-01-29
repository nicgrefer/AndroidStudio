package com.example.ejer7_fragmentstipoexamen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ejer7_fragmentstipoexamen.databinding.FragmentIncrementoBinding

class FragmentIncremento : Fragment() {
    lateinit var binding: FragmentIncrementoBinding
    lateinit var accionSumar: ComunicandoFragment

    private var numActual: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentIncrementoBinding.inflate(inflater,container,false)
        binding.bttIncrementar.setOnClickListener {
            numActual = numActual + 1
            accionSumar.sumar(numActual)
        }
        return binding.root
    }

    interface ComunicandoFragment{
        fun sumar(numActual:Int)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        accionSumar = context as ComunicandoFragment
    }

}