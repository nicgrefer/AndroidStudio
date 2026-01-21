package com.example.ejem10_fragmentconparametro

import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.ejem10_fragmentconparametro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().apply {
            add(R.id.frc_principal, FragmentConParametro.newInstance("valor 1", "valor 2"))
            commit()
        }
        registerForContextMenu(binding.main)// vinculamos el menu con el activity
    }

    // alt + isert -> menu para importar override
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId){
            R.id.opcion1 ->
                Toast.makeText(this,"Opcion 1", Toast.LENGTH_SHORT).show()
            R.id.opcion2 ->
                Toast.makeText(this,"Opcion 2", Toast.LENGTH_SHORT).show()
            R.id.opcion3 ->
                Toast.makeText(this,"Opcion 3", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu) // vinculamos el menu con el activity
        return super.onCreateOptionsMenu(menu)
    }

    // Menu contextual -> al mantener pulsado en el item (mein) sale el menu
    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.opcion1 ->
                Toast.makeText(this,"Opcion 1", Toast.LENGTH_SHORT).show()
            R.id.opcion2 ->
                Toast.makeText(this,"Opcion 2", Toast.LENGTH_SHORT).show()
            R.id.opcion3 ->
                Toast.makeText(this,"Opcion 3", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
        return super.onContextItemSelected(item)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.menu, menu)
    }
}



