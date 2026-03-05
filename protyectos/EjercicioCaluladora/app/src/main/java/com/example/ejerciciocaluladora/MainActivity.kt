package com.example.ejerciciocaluladora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ejerciciocaluladora.ui.theme.EjercicioCaluladoraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Calculadora()
            /*
            EjercicioCaluladoraTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }

             */
        }
    }
}
@Composable
fun Calculadora() {
    var contadorPantalla by remember { mutableStateOf("") }
    val historial = remember { mutableStateListOf<String>() }
    Column(modifier = Modifier.padding(16.dp)) {

        // PANTALLA
        Text(
            text = contadorPantalla,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .padding(20.dp),
            fontSize = 40.sp,
            textAlign = TextAlign.End
        )

        Spacer(modifier = Modifier.height(16.dp))

        // FILA 1
        Row(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = { contadorPantalla += "7" },
                modifier = Modifier.weight(1f)
            ) { Text("7") }
            Button(
                onClick = { contadorPantalla += "8" },
                modifier = Modifier.weight(1f)
            ) { Text("8") }
            Button(
                onClick = { contadorPantalla += "9" },
                modifier = Modifier.weight(1f)
            ) { Text("9") }
            Button(
                onClick = { contadorPantalla += "/" },
                modifier = Modifier.weight(1f)
            ) { Text("/") }
        }

        // FILA 2
        Row(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = { contadorPantalla += "4" },
                modifier = Modifier.weight(1f)
            ) { Text("4") }
            Button(
                onClick = { contadorPantalla += "5" },
                modifier = Modifier.weight(1f)
            ) { Text("5") }
            Button(
                onClick = { contadorPantalla += "6" },
                modifier = Modifier.weight(1f)
            ) { Text("6") }
            Button(
                onClick = { contadorPantalla += "*" },
                modifier = Modifier.weight(1f)
            ) { Text("*") }
        }

        // FILA 3
        Row(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = { contadorPantalla += "1" },
                modifier = Modifier.weight(1f)
            ) { Text("1") }
            Button(
                onClick = { contadorPantalla += "2" },
                modifier = Modifier.weight(1f)
            ) { Text("2") }
            Button(
                onClick = { contadorPantalla += "3" },
                modifier = Modifier.weight(1f)
            ) { Text("3") }
            Button(
                onClick = { contadorPantalla += "-" },
                modifier = Modifier.weight(1f)
            ) { Text("-") }
        }

        // FILA 4
        Row(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = { contadorPantalla = "" },
                modifier = Modifier.weight(1f)
            ) { Text("C") }
            Button(
                onClick = { contadorPantalla += "0" },
                modifier = Modifier.weight(1f)
            ) { Text("0") }
            Button(
                onClick = { historial.add(contadorPantalla)
                            contadorPantalla = "" },
                modifier = Modifier.weight(1f)
            ) { Text("=") }
            Button(
                onClick = { contadorPantalla += "+" },
                modifier = Modifier.weight(1f)
            ) { Text("+") }
        }

        Surface(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(),
            color = Color.LightGray.copy(alpha = 0.3f),
            shape = RoundedCornerShape(12.dp),
            tonalElevation = 4.dp
        ) {
            // 2. Configuramos el LazyColumn para leer la lista
            LazyColumn(modifier = Modifier.padding(8.dp)) {
                items(historial.size) { index ->
                    Text(
                        text = historial[index],
                        modifier = Modifier.padding(vertical = 4.dp).fillMaxWidth(),
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Calculadora()
}