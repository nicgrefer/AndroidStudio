package com.example.ejem08_viewmodels

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejem08_viewmodels.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val contadorViewModel : Contador by viewModels()
        binding.lifecycleOwner=this
        binding.cont=contadorViewModel

        val cNormal : ContadorNormal = ContadorNormal();
        binding.bIncrementar.setOnClickListener {
            contadorViewModel.increment()
            binding.cont = contadorViewModel
            cNormal.incrementar()
            binding.contNormal = cNormal

            // Funcion que recive por argumento otra funcion
            if (cNormal.contador>5){
                lanzarSaludo {conToast()}
            }else{
                lanzarSaludo {conSnackBar()}
            }

        }
    }

    // ej: Cuando llamas con Toast -> nombrePersonalizado se remplazara por la funcion conToast()
    // con -> Unit decimos que es de tipo funcion
    private fun lanzarSaludo(nombrePersonalizado:()-> Unit){
        // desarroyo de la funcion
        Log.d("depurando","Depurando saludo...")
        nombrePersonalizado()
    }
    private fun conToast() {
        Toast.makeText(this, "Preparando el saludo", Toast.LENGTH_SHORT).show()
    }
    private fun conSnackBar(){
        Snackbar.make(binding.root, "Preparando el saludo", Snackbar.LENGTH_SHORT).show()
    }

}