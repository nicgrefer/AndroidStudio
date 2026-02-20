package local

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.casadoalberto.BD
import com.example.casadoalberto.Resultado
import com.example.casadoalberto.ResultadoDAO
import com.example.casadoalberto.databinding.FragmentCalculatorBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CalculatorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CalculatorFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var binding: FragmentCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    var valorParcial: Int=0
    var resultado: Boolean=false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentCalculatorBinding.inflate(inflater, container, false)


        val botones = with(binding) {
            listOf(b0, b1, b2, b3, b4, b5, b6, b7, b8, b9)
        }

        botones.forEach { boton ->
            boton.setOnClickListener {
                if (binding.bResultado.text.toString() == "+")
                    binding.bResultado.text=""
                if (resultado) {
                    binding.bResultado.text=""
                    resultado=false
                    binding.bIgual.isEnabled=false
                }
                binding.bResultado.append(boton.text)
            }
        }

        binding.bSumar.setOnClickListener {
            valorParcial=binding.bResultado.text.toString().toInt()
            binding.bResultado.text="+"
            binding.bIgual.isEnabled=true
            binding.bSumar.isEnabled=false

        }
        binding.bIgual.setOnClickListener {
            Log.d("depurando",valorParcial.toString())
            val result = (valorParcial+binding.bResultado.text.toString().toInt()).toString()
            binding.bResultado.text= result
            resultado=true
            binding.bIgual.isEnabled=false
            binding.bSumar.isEnabled=true
            parentFragmentManager.setFragmentResult("requestKey", bundleOf("resultado" to result))

            val r : Resultado = Resultado(0,result)
            Room.databaseBuilder(requireContext(), BD::class.java, "bdResultados").allowMainThreadQueries().build().resultadoDAO()!!.insertar(r)
        }


        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CalculatorFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CalculatorFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}