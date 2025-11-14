package com.example.ejem02_constraintlayaut

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejem02_constraintlayaut.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Esta es la primera forma de implementar un listener
        // creando una clase anónima que implemente la interfaz View.OnClickListener
        // y sobreescribiendo el método onClick
        /*
        var pulsacion = object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.d("depurando", "Pulsado")
            }
        }



        // Segunda forma de implementar un listener
        // Usando una expresión lambda (con parameto) ahora codigo más conciso
        // Si por ejemplo queremos recojer el contenido del botón pulsado esta seria la mejor forma
        // (la 3 opción no nos permite recoger el parámetro)
        var pulsacion2 = View.OnClickListener() { boton ->
            Log.d("depurando", "Pulsado")

        }
*/
        // Tercera forma de implementar un listener
        // Usando una expresión lambda sin parámetro
        var pulsacion = View.OnClickListener () {
            Log.d("depurando", "Pulsado")
            (binding.lvNombres.adapter as ArrayAdapter<String>).add(binding.tietNombre.toString())
        }

        binding.b1.setOnClickListener (pulsacion)
        binding.b2.setOnClickListener (pulsacion)
        binding.b3.setOnClickListener (pulsacion)

        // tiene que ser mutable para poder añadir elementos y poner de que tipo son los elementos (en este caso String)
        val listaDatos = mutableListOf<String>("Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4", "Elemento 5")
        // encargamos el adaptador al listview en el layout
        var adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaDatos)
        binding.lvNombres.adapter = adaptador

    }
}