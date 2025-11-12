package com.example.calculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var operador: String? = null
    private var primerNumero: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // numeros
        val botonesNumeros = listOf(
            binding.btn1, binding.btn2, binding.btn3,
            binding.btn4, binding.btn5, binding.btn6,
            binding.btn7, binding.btn8, binding.btn9
        )

        for (boton in botonesNumeros) {

            boton.setOnClickListener { botonPulsado ->
                val numero = (botonPulsado as android.widget.Button).text.toString()
                if (binding.txtDisplay.text.toString() == "0" || (operador != null && primerNumero != null)) {
                    binding.txtDisplay.text = numero
                } else {
                    binding.txtDisplay.append(numero)
                }
            }
          /*  boton.setOnClickListener {
                val numero = boton.text.toString()
                if (binding.txtDisplay.text.toString() == "0" || (operador != null && primerNumero != null)) {
                    binding.txtDisplay.text = numero
                } else {
                    binding.txtDisplay.append(numero)
                }
            }*/
        }

        // botones operaciones
        binding.btnSuma.setOnClickListener { botonPulsado -> seleccionarOperador((botonPulsado as Button).text.toString())}
        binding.btnResta.setOnClickListener { botonPulsado -> seleccionarOperador("-") }

        // igual
        binding.btnIgual.setOnClickListener {
            val segundoNumero = binding.txtDisplay.text.toString().toIntOrNull()
            if (primerNumero != null && operador != null && segundoNumero != null) {
                val resultado = when (operador) {
                    "+" -> primerNumero!! + segundoNumero
                    "-" -> primerNumero!! - segundoNumero
                    else -> 0
                }
                binding.txtDisplay.text = resultado.toString()
                operador = null
                primerNumero = null
            }
        }

        // clear
        binding.btnClear.setOnClickListener {
            binding.txtDisplay.text = "0"
            operador = null
            primerNumero = null
        }
    }

    private fun seleccionarOperador(op: String) {
        primerNumero = binding.txtDisplay.text.toString().toIntOrNull()
        operador = op
        binding.txtDisplay.text = "0"
    }
}
