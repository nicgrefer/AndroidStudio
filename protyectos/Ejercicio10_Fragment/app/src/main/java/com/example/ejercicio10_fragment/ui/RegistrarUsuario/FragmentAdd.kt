package com.example.ejercicio10_fragment.ui.RegistrarUsuario

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.example.ejercicio10_fragment.BD
import com.example.ejercicio10_fragment.R
import com.example.ejercicio10_fragment.Usuario
import com.example.ejercicio10_fragment.databinding.FragmentAddBinding


class FragmentAdd : Fragment() {
    private lateinit var binding: FragmentAddBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddBinding.inflate(inflater, container, false)
        val baseDatos = Room.databaseBuilder(requireContext(), BD::class.java, "bdUsuarios").allowMainThreadQueries().build()

        binding.bttList.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentAdd_to_fragmentList)
        }

        binding.bttAdd.setOnClickListener {
            val user = Usuario(0,binding.tietUser.text.toString(),
                                binding.tietCode.text.toString())
            baseDatos.UsuarioDAo()?.insert(user)
        }

        return binding.root
    }
}