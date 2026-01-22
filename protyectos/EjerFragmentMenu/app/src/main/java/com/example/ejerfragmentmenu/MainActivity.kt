package com.example.ejerfragmentmenu

import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejerfragmentmenu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registerForContextMenu(binding.main)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.itm_fragment1 -> {
                Toast.makeText(this, "Cargando fragment 1", Toast.LENGTH_SHORT).show()
                supportFragmentManager.beginTransaction().apply{
                    add(R.id.fcv_modular, Fragment1())
                    commit()
                }
            }

            R.id.itm_fragment2 -> {
                Toast.makeText(this, "Cargando fragment 2", Toast.LENGTH_SHORT).show()
                supportFragmentManager.beginTransaction().apply{
                    add(R.id.fcv_modular, Fragment2())
                    commit()
                }
            }
            R.id.itm_fragment3 -> {
                Toast.makeText(this, "Cargando fragment 3", Toast.LENGTH_SHORT).show()
                supportFragmentManager.beginTransaction().apply{
                    add(R.id.fcv_modular, Fragment3())
                    commit()
                }
            }
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