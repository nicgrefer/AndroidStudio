package com.example.ejerciciofragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.ejerciciofragments.databinding.FragmentPrimerBinding
import com.example.ejerciciofragments.databinding.FragmentSegundoBinding
import kotlin.getValue


class SegundoFragment : Fragment() {

    private lateinit var binding: FragmentSegundoBinding
    private val contadorViewModel : ContadorViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSegundoBinding.inflate(inflater,container,false)

        binding.lifecycleOwner=this
        binding.miDato=contadorViewModel

        binding.btnSumar.setOnClickListener {
            contadorViewModel.sumar()
        }
        return binding.root
    }


}