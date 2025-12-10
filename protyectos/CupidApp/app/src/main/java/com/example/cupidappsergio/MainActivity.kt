package com.example.cupidappsergio

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cupidappsergio.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaParejas = mutableListOf<Pareja>()


        val llamadaConRetorno = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ resultado->
            if(resultado.resultCode==RESULT_OK){
                val  parejaDevuelta: Pareja = resultado.data?.getParcelableExtra<Pareja>("PAREJA_DEVUELTA", Pareja::class.java) as Pareja
                listaParejas.add(parejaDevuelta)

                binding.rvEnamorados.adapter?.notifyDataSetChanged()
            }
        }

        val adapter = ParejaAdapter(listaParejas)
        binding.rvEnamorados.adapter=adapter
        binding.rvEnamorados.layoutManager= LinearLayoutManager(this)



        binding.bInsertar.setOnClickListener { boton->

            val intent = Intent(this, SegundoActivity::class.java)
                llamadaConRetorno.launch(intent)

        }
    }
}