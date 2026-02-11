package com.example.ejem14_persistencia

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ejem14_persistencia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(getSharedPreferences("MisDatos", MODE_PRIVATE)!= null){
            val datoCargado = getSharedPreferences("MisDatos", MODE_PRIVATE).getString("datoGuardado", "No hay dato guardado")
            binding.tvDato.text = datoCargado
        }
        val baseDatos: BD=Room.databaseBuilder(this, BD::class.java, "bdUsuarios")
            .allowMainThreadQueries().build()



        binding.bGuardarDato.setOnClickListener {
            val user : Usuario = Usuario(0,binding.tietNombre.text.toString(), binding.tietEdad.text.toString().toInt())
            baseDatos.usuarioDao()?.insertarUsuario(user)

            val dato:String = user.nombre + " " + user.edad + " años"
            val sharedPreferences = getSharedPreferences("MisDatos", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("datoGuardado", dato)
            editor.apply()
        }
        binding.bEliminar.setOnClickListener {
            val id=binding.tietIdentificador.text.toString().toInt()
            baseDatos.usuarioDao()?.eliminarUsuario(id)

        }
        binding.bRecuperarUsuario.setOnClickListener {
            val id=binding.tietIdentificador.text.toString().toInt()
            val usuario:Usuario= baseDatos.usuarioDao()?.recuperarUsuario(id)!!
            binding.user=usuario
        }

        binding.bListar.setOnClickListener {
            val listaUsuarios : List<Usuario> = baseDatos.usuarioDao()?.listaUsuarios()!!
            for(usuario in listaUsuarios){
                Log.d("usuarios", usuario.toString())
            }
        }

    }
}