package com.example.casadoalberto

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.casadoalberto.databinding.ActivityMainBinding
import com.example.casadoalberto.databinding.FragmentHistorialBinding
import local.CalculatorFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.setFragmentResultListener("requestKey", this) { key, bundle ->
            val result = bundle.getString("resultado")
            binding.textView.text = result
        }

        binding.bHistorial.setOnClickListener {
            val dialogo: AlertDialog.Builder = AlertDialog.Builder(this)
            dialogo.setTitle("Estas seguro?")
            dialogo.setPositiveButton("Sí") { dialogInterface, i ->
                supportFragmentManager.beginTransaction().apply {
                    replace(
                        binding.fragmentContainerView.id,
                        HistorialFragment.newInstance(binding.textView.text.toString())
                    )
                    commit()
                }
            }


            dialogo.setNegativeButton("No") { dialogInterface, i -> }
            dialogo.show()
        }
    }
}
