package com.example.ejem01_holamundo

import android.os.Bundle
import android.renderscript.ScriptGroup
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejem01_holamundo.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
class MainActivity : AppCompatActivity() {
    // no es apropiado usar -> findViewById<>(R.id.b)
    // se usa View Binding
    // bindig : enlazar lo que es el código con lo que es el interfaz gráfica de manera directa
    // para activar el View Binding
    // abrimos el build.gradle (Module: app)
    // variable a nivel de clase llamada binding
    // como es una reerencia pero no esta creado y no sabemos si lo vamos a usar o no, hay que inicializarla con lateinit

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // con operador. nos salen los comoponentes de la interfaz gráfica
        // binding.b -> botón
        // damos a tvNombre el nombre de Paula
        //binding.tvNombre.text = "Paula";
        // usamos un lambda para el evento onClick cuando el interfaz solo tiene un metodo a desarrollar
        // el onclicklistener -> tiene el metodo onClick y se usa lambda para ello (lambda se ahorra codigo)
        binding.bSaludar.setOnClickListener {
        val user: Usuario = Usuario(
            binding.tieNombre.text.toString(),
            binding.tieEdad.text.toString().toInt(),
            binding.cbSoltero.isActivated,
            binding.sCiudad.selectedItem.toString(),
            // obtener el texto del radio button seleccionado del radio group mediante su id
            // buscar el radio button seleccionado dentro del radio group y obtener su texto
            findViewById<RadioButton>(binding.rgColorFavorito.checkedRadioButtonId).text.toString()
        )
            // al pulsar el botón, se ejecuta este código
            Log.d("depurando", "Hola " + user)
        }

        //crear perspna
        val Pepe: Usuario = Usuario("pepe", 30, false)

        Log.d("depurando", "Persona: " + Pepe)
        binding.user = Pepe

        // creamos un data class

        // creamos una lista
        var datos: List<String> = listOf("Madrid", "Barcelona", "Valencia", "Sevilla", "Zaragoza")
        val adapterDAtos: ArrayAdapter<String> = ArrayAdapter(
            this,// el primero es el contexto (El objeto Activity actual)
            android.R.layout.simple_list_item_1, // Constante que representa un diseño de recurso de Android predefinido para un elemento de lista simple.
            // definida en el sistema operativo Android.
            datos // la lista de datos a mostrar
        )
       var adaptador: ArrayAdapter <String> = ArrayAdapter (this,android.R.layout.simple_list_item_1,datos)
        binding.lvListado.adapter = adaptador

        var datosUsuario: ArrayAdapter <Usuario> = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            listOf(
                Usuario("Ana", 25, true, "Madrid", "Rojo"),
                Usuario("Luis", 28, false, "Barcelona", "Azul"),
                Usuario("Marta", 22, true, "Valencia", "Verde"),
                Usuario("Carlos", 35, false, "Sevilla", "Amarillo"),
                Usuario("Sofia", 30, true, "Zaragoza", "Morado")
            )
        )

       // binding.lvListado.adapter = adapterDAtos
        binding.spListado.adapter = datosUsuario

        // este para spinne
        binding.spListado.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(adapdor: AdapterView<*>?, view: View?, posicion: Int, id: Long) {
                Log.d("depurando" , adapdor?.selectedItem.toString())
            }

            override fun onNothingSelected(adapdor: AdapterView<*>?) {
               Log.d("depurando", "Nada seleccionado")
            }
        }

        binding.cbSoltero.setOnCheckedChangeListener { cbsoltero, isSoltero ->
            Log.d("depurando", "Checkbox seleccionado: $isSoltero")
        }

        binding.rgColorFavorito.setOnCheckedChangeListener { group, checkedId ->
           //Log.d("depurando", findViewById<RadioButton>(checkedId).text.toString())
           Log.d("depurando", group.checkedRadioButtonId.toString()+" - "+ checkedId)
            /*
            if (group.checkedRadioButtonId == binding.rbRojo.id) {
                Log.d("depurando", "Color Rojo seleccionado")
            } else if (group.checkedRadioButtonId == binding.rbAzul.id) {
                Log.d("depurando", "Color Azul seleccionado")
            } else if (group.checkedRadioButtonId == binding.rbVerde.id) {
                Log.d("depurando", "Color Verde seleccionado")
            }

            otra opcion */

            /*
            when(group.checkedRadioButtonId){
                binding.rbRojo.id -> Log.d("depurando", "Color Rojo seleccionado")
                binding.rbAzul.id -> Log.d("depurando", "Color Azul seleccionado")
                binding.rbVerde.id -> Log.d("depurando", "Color Verde seleccionado")
            }
            */

        }


/*
        // este es para lista ya que usa onItemClickListener y solo tiene un metodo
        binding.lvListado.onItemClickListener = AdapterView.OnItemClickListener { adapdor, view, position, id ->
            Log.d("depurando", adapdor?.getItemAtPosition(position).toString())

 */
        }

    }



