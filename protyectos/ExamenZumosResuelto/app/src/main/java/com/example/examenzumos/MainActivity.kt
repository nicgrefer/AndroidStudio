package com.example.examenzumos

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.examenzumos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var zumos = mutableListOf<Zumo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.usuario = Usuario("palo_valdes","1234")

        binding.lvZumos.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,zumos)

        val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ resultado ->
            if(resultado.resultCode == RESULT_OK){

                zumos.addAll(resultado.data!!.getParcelableArrayListExtra("zumos",Zumo::class.java)!!)
                (binding.lvZumos.adapter as ArrayAdapter<*>).notifyDataSetChanged()

                var sum = 0
                for(zumo in zumos)
                    sum+=zumo.precio

                binding.tvPrecio.text =  resources.getQuantityString(R.plurals.precios,sum,sum)
            }
        }

        binding.button.setOnClickListener {
            binding.tilNombre.error = if(binding.tietNombre.text.toString().equals("palo_valdes")) null else resources.getString(R.string.usuario_incorrecto)
            binding.tilPassword.error = if(binding.tietPassword.text.toString().equals("1234")) null else resources.getString(R.string.password_incorrecta)

            if(binding.tilNombre.error == null && binding.tilPassword.error == null){
                binding.tietNombre.text?.clear()
                binding.tietPassword.text?.clear()

                zumos.clear()
                (binding.lvZumos.adapter as ArrayAdapter<*>).notifyDataSetChanged()

                val intent = Intent(this,ActivitySeleccionZumos::class.java)

                launcher.launch(intent)

            }
        }

    }
}