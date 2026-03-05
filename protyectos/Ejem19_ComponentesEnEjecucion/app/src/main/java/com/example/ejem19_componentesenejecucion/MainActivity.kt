package com.example.ejem19_componentesenejecucion

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.ejem19_componentesenejecucion.ui.theme.Ejem19_ComponentesEnEjecucionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejem19_ComponentesEnEjecucionTheme {
                CreandoBotones()
            }
        }
    }
}

@Composable
fun CreandoBotones() {
    val context = LocalContext.current
    LazyColumn () {
        items (20) { numero ->
            val textoBoton = "Boton " + (numero+1)
            Button(onClick = { Log.d("depurando", textoBoton)
                    Toast.makeText(context, textoBoton, Toast.LENGTH_SHORT).show() }) {
                Text(text = textoBoton)
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Ejem19_ComponentesEnEjecucionTheme {
        CreandoBotones()
    }
}