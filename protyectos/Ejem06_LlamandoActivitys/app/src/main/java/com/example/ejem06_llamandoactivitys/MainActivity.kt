package com.example.ejem06_llamandoactivitys

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejem06_llamandoactivitys.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val listaUsuarios = mutableListOf<Usuario>()
    private lateinit var adapter: UsuarioAdapter

    // Registrar la actividad para recibir resultados
    private val llamadaConRetorno =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { resultado ->
            if (resultado.resultCode == RESULT_OK) {
                val usuarioDevuelto = resultado.data?.getParcelableExtra<Usuario>("USUARIO_DEVUELTO")
                usuarioDevuelto?.let {
                    // Agregamos el usuario recibido y notificamos al Adapter
                    listaUsuarios.add(it)
                    adapter.notifyItemInserted(listaUsuarios.size - 1)
                    binding.rvUsuarios.scrollToPosition(listaUsuarios.size - 1)
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializamos el Adapter y RecyclerView
        adapter = UsuarioAdapter(listaUsuarios)
        binding.rvUsuarios.adapter = adapter
        binding.rvUsuarios.layoutManager = LinearLayoutManager(this)

        // Botón para pasar a la segunda actividad
        binding.bPasarActivity2.setOnClickListener {
            val nombre = binding.tietNombre.text.toString()
            val edad = binding.tietEdad.text.toString().toIntOrNull() ?: 0
            val email = binding.tietEmail.text.toString()

            val usuario = Usuario(nombre, edad, email)

            // Lanzamos Segunda Activity sin agregar a la lista todavía
            val intent = Intent(this, SegundoActivity::class.java)
            intent.putExtra("DATO", usuario)
            llamadaConRetorno.launch(intent)
        }
    }
}
