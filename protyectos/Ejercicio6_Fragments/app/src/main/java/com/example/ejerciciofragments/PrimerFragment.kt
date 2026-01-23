package com.example.ejerciciofragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.ejerciciofragments.databinding.FragmentPrimerBinding




class PrimerFragment : Fragment() {

    private lateinit var binding: FragmentPrimerBinding
    private val contadorViewModel : ContadorViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPrimerBinding.inflate(inflater,container,false)


        binding.lifecycleOwner=this
        binding.miDato=contadorViewModel

        binding.btnSumar.setOnClickListener {
            contadorViewModel.sumar()
        }

        return binding.root
    }

}