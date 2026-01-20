package com.example.ejem10_fragmentconparametro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ejem10_fragmentconparametro.databinding.FragmentConParametroBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentConParametro.newInstance] factory method to
 * create an instance of this fragment.
 * Cuando entra el dato como tal no lo meto comop String sino sino cpm el Bundle
 * Asociamos los strings "param1 = it.getString(ARG_PARAM1)" con los parametros y luego
 * los guardamos en " private var param1: String? = null"
 */
class FragmentConParametro : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    lateinit var binding: FragmentConParametroBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentConParametroBinding.inflate(inflater,container,false)
        binding.tvDatosParametro.text = "Parametro 1:$param1 \n Parametro 2: $param2"
        return binding.root

    }

companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentConParametro().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    }
