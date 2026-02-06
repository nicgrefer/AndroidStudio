package com.example.ejem14_persistenciadb

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.ejem14_persistenciadb.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // al abrir la aplicacion leer del xml el dato guardarlo y meterlo en el text view
        val sharedPreferences = getSharedPreferences("MisDatos", MODE_PRIVATE)
        binding.tvDato.text = sharedPreferences.getString("datoGuardado", "No hay dato guardado")


        // hacemos referencia a la base de datos
        val baseDatos: BD=Room.databaseBuilder(this, BD::class.java, "bdUsuarios").allowMainThreadQueries().build()



        // SHARED PREFERENCES (Primer tipo de persistencia, el más sencillo, se guarda en un archivo XML,
        // se utiliza para guardar datos simples como configuraciones o preferencias del usuario)
        binding.bttAdd.setOnClickListener {
            // recuperamos de la casilla un dato pasado a string
            //val dato = binding.tietDatoGuardar.text.toString()
            // recibe dos parametros, el nombre del archivo donde se guardará el dato y el modo de acceso (en este caso privado)
            // es decir estamos creando un fichero XML llamado "MisDatos" donde se guardará el dato
            //val sharedPreferences = getSharedPreferences("MisDatos", MODE_PRIVATE)
            // lo abrimos en modo edición para poder guardar el dato, no solo en modo lectura,
            //val editor = sharedPreferences.edit()
            // le pasamos el dato a guardar con una clave (en este caso "datoGuardado")
            //editor.putString("datoGuardado", dato)
            // aplicamos los cambios para que se guarde el dato en el archivo XML
            //editor.apply()

            val dato = binding.tietNombre.text.toString() // Nombre
            val usuario = Usuario(0,binding.tietNombre.text.toString(), binding.tietEdad.text.toString().toInt())
            baseDatos.UsuarioDAo()?.insert(usuario)

            Log.d("depurando", usuario.toString())
            val editor = sharedPreferences.edit()
            editor.putString("datoGuardado", dato)

        }
    }
}