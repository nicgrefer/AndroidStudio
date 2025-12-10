package com.example.ejemploexamen2020

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.ejemploexamen2020.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var listParejas = mutableListOf<Pareja>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val launcher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { resultado ->
            if (resultado.resultCode == RESULT_OK) {
                var pareja: Pareja? = resultado.data?.getParcelableExtra<Pareja>("pareja")
                listParejas.add(pareja!!)
                binding.rvParejas.adapter?.notyfyItemInserted(listParejas.size - 1)
            }
        }

        binding.bttInsert.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            launcher.launch(intent)
        }
    }
}
