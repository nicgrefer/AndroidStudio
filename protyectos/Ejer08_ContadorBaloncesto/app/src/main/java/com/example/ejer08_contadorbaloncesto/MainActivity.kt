package com.example.ejer08_contadorbaloncesto

import android.os.Bundle
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.example.ejer08_contadorbaloncesto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var puntosLocal = 0
    private var puntosVisitante = 0

    // Configuración escalable
    private val numJugadores = 14
    private val numColumnas = 11

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        inicializarUI()
        generarBotones()
    }

    private fun inicializarUI() {
        actualizarMarcador()

        // Configurar RadioButtons con listeners
        binding.rbTiroLibre.setOnClickListener { desmarcarOtros(it as RadioButton) }
        binding.rbCanasta.setOnClickListener { desmarcarOtros(it as RadioButton) }
        binding.rbTriple.setOnClickListener { desmarcarOtros(it as RadioButton) }

        // Seleccionar Tiro Libre por defecto
        binding.rbTiroLibre.isChecked = true
    }

    private fun desmarcarOtros(seleccionado: RadioButton) {
        listOf(binding.rbTiroLibre, binding.rbCanasta, binding.rbTriple).forEach {
            if (it != seleccionado) it.isChecked = false
        }
    }

    private fun generarBotones() {
        // Configurar GridLayouts
        binding.glButtonsLocal.apply {
            columnCount = numColumnas
            rowCount = (numJugadores + numColumnas - 1) / numColumnas
        }

        binding.glButtonsVisitante.apply {
            columnCount = numColumnas
            rowCount = (numJugadores + numColumnas - 1) / numColumnas
        }

        // Generar botones para ambos equipos
        for (i in 4..numJugadores) {
            agregarBotonJugador(binding.glButtonsLocal, i, true)
            agregarBotonJugador(binding.glButtonsVisitante, i, false)
        }
    }

    private fun agregarBotonJugador(
        gridLayout: androidx.gridlayout.widget.GridLayout,
        numeroJugador: Int,
        esLocal: Boolean
    ) {
        val button = AppCompatButton(this).apply {
            text = numeroJugador.toString()

            // Configuración de tamaño optimizada
            val size = (resources.displayMetrics.widthPixels / numColumnas) - 8
            layoutParams = ViewGroup.MarginLayoutParams(size, size).apply {
                setMargins(4, 4, 4, 4)
            }

            // Estilo del botón
            setBackgroundColor(ContextCompat.getColor(context, android.R.color.holo_blue_light))
            setTextColor(ContextCompat.getColor(context, android.R.color.white))
            textSize = 16f

            // Listener para sumar puntos
            setOnClickListener {
                val puntos = obtenerPuntosSeleccionados()
                if (esLocal) {
                    puntosLocal += puntos
                } else {
                    puntosVisitante += puntos
                }
                actualizarMarcador()
            }
        }

        gridLayout.addView(button)
    }

    private fun obtenerPuntosSeleccionados(): Int {
        return when {
            binding.rbTiroLibre.isChecked -> 1
            binding.rbCanasta.isChecked -> 2
            binding.rbTriple.isChecked -> 3
            else -> 1
        }
    }

    private fun actualizarMarcador() {
        binding.tvContador.text = "Local: $puntosLocal - Visitante: $puntosVisitante"
    }
}