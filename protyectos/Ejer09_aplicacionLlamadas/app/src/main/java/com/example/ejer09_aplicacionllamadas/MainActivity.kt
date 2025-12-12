package com.example.ejer09_aplicacionllamadas

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import android.provider.ContactsContract
import com.example.ejer09_aplicacionllamadas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val REQUEST_CONTACT_PERMISSION = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        // Configurar RecyclerView
        binding.rvContactos.layoutManager = LinearLayoutManager(this)

        // Botón cargar contactos
        binding.bttLlamar.setOnClickListener {
            pedirPermiso()
        }
    }

    private fun pedirPermiso() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.READ_CONTACTS),
                REQUEST_CONTACT_PERMISSION
            )
        } else {
            cargarContactosEnLista()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == REQUEST_CONTACT_PERMISSION &&
            grantResults.isNotEmpty() &&
            grantResults[0] == PackageManager.PERMISSION_GRANTED
        ) {
            cargarContactosEnLista()
        }
    }

    private fun cargarContactosEnLista() {
        val lista = obtenerTodosLosContactos()

        val adapter = ContactAdapter(lista) { contacto ->
            // Al hacer clic → llamar
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:${contacto.numero}")
            }
            startActivity(intent)
        }

        binding.rvContactos.adapter = adapter
    }

    private fun obtenerTodosLosContactos(): List<Contacto> {

        val lista = mutableListOf<Contacto>()

        val projection = arrayOf(
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone.NUMBER
        )

        val cursor = contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            projection,
            null,
            null,
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC"
        )

        cursor?.use {
            while (it.moveToNext()) {

                val nombre = it.getString(
                    it.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
                )
                val numero = it.getString(
                    it.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER)
                )

                lista.add(Contacto(nombre, numero))
            }
        }

        return lista
    }
}
