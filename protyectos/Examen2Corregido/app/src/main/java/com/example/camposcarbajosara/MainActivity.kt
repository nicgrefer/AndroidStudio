package com.example.camposcarbajosara

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import com.example.camposcarbajosara.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), FragmentCalculadora.EnviandoResultado {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // CREAMOS LA BASE DE DATOS
        var baseDatos = Room.databaseBuilder(this, BD::class.java, "bdExamen").allowMainThreadQueries().build()
        //var dao = baseDatos.resultadoDao()!!

        // recoger el dato que nos pasa desde fragment


        // pulsamos el boton para ir al fragment historial
        binding.bHistorial.setOnClickListener {
            var dialogo = AlertDialog.Builder(this)
            dialogo.setTitle("Continuar")
            dialogo.setMessage("¿Seguro que quieres ir al Historial?")

            dialogo.setPositiveButton("Si") {
                dInterface, i ->
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragmentContainerView, FragmentHistorial.newInstance(binding.textView.text.toString()))
                    commit()
                }
            }

            dialogo.setNegativeButton("No") {
                dInterface, i ->
                dInterface.dismiss()
            }
            dialogo.show()
        }
    }

    override fun enviarResultado(resultado: String) {
        binding.textView.text = resultado
    }
}