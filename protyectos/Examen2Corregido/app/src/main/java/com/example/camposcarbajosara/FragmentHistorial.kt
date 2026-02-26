package com.example.camposcarbajosara

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.room.Room
import com.example.camposcarbajosara.databinding.FragmentHistorialBinding

private const val ARG_PARAM1 = "param1"

class FragmentHistorial : Fragment() {
    private var param1: String? = null

    lateinit var binding: FragmentHistorialBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistorialBinding.inflate(inflater, container, false)

        // el parametro desde main lo ponemos en un toast
        var textoToast = param1
        Toast.makeText(requireContext(), "El número que viene del Activity es: $textoToast", Toast.LENGTH_SHORT).show()

        // recuperamos la bd
        var baseDatos = Room.databaseBuilder(requireContext(), BD::class.java, "bdExamen").allowMainThreadQueries().build()
        var dao = baseDatos.resultadoDao()!!

        // creamos el adapter
        var listaResultados = dao.listar().toMutableList()
        var adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, listaResultados)
        binding.lvLista.adapter = adapter

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String) =
            FragmentHistorial().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}