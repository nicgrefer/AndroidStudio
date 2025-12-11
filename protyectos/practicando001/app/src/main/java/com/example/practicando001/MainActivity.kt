package com.example.practicando001

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practicando001.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        val listapareja = mutableListOf<Parejas>()

        val launch = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->

            if (result.resultCode == RESULT_OK){
                val parejaDevuelta: Parejas = result.data?.getParcelableExtra<Parejas>("pareja",
                    Parejas::class.java) as Parejas
                listapareja.add(parejaDevuelta)
                binding.rvParejas.adapter?.notifyDataSetChanged()
            }
        }

        val adapter = ParejaAdapter(listapareja)


        binding.bttAddPareja.setOnClickListener {
            var intent = Intent(this, SecondActivity::class.java)
            launch.launch(intent)
        }

    }
}