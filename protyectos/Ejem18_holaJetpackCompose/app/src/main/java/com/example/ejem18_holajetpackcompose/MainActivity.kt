package com.example.ejem18_holajetpackcompose

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ejem18_holajetpackcompose.ui.theme.Ejem18_holaJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiFuncionVisual()
            /*
            Ejem18_holaJetpackComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MiFuncionVisual(

                    )
                }
            }

             */
        }
    }
}

@Composable
fun MiFuncionVisual(){
    // Estado para guardar la opción de sexo seleccionada
    var selectedSex by remember { mutableStateOf("Hombre") }

    Column {
        Text(text = "Hola soy un texto", modifier = Modifier.padding(16.dp))
        Row (modifier = Modifier.padding(16.dp).fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
            Text(text = "Nombre :",
                modifier = Modifier.padding(16.dp).weight(0.30f)
            )
            TextField(placeholder =
                {
                    Text(text = "Escrive tu nombre")
                },
                value = "",
                onValueChange = {},
                modifier = Modifier.weight(0.70f)
            )
        }
        Row(modifier = Modifier.padding(16.dp).fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
            Text(
                text = "Sexo: ",
                modifier = Modifier.padding(end = 16.dp)
            )
            // Opción Hombre
            RadioButton(
                selected = selectedSex == "Hombre",
                onClick = { selectedSex = "Hombre" }
            )
            Text(
                text = "Hombre",
                modifier = Modifier.padding(end = 16.dp)
            )
            // Opción Mujer
            RadioButton(
                selected = selectedSex == "Mujer",
                onClick = { selectedSex = "Mujer" }
            )
            Text(
                text = "Mujer"
            )
        }

        Button(modifier = Modifier.fillMaxWidth(), onClick = { /*TODO*/ }) {
            Row {
                Text(text = "Incrementar")
            }
        }

        Row(modifier = Modifier.padding(16.dp).fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
            Text(
                text = "Contador: ",
                modifier = Modifier.padding(end = 16.dp)
            )
            Button(modifier = Modifier.padding(end = 16.dp).weight(0.70f), onClick = { /*TODO*/ }, enabled = false) {
                Row {
                  //  Image(painter = painterResource(id = R.drawable.outline_123_24))
                    Text(text = "Incrementar")
                }
            }
        }
        Row(modifier = Modifier.padding(16.dp).fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
            Switch(modifier = Modifier.padding(16.dp).fillMaxWidth().weight(0.50f), checked = true,onCheckedChange = {/*TODO*/})
            Text(text = "havilitar contador",modifier = Modifier.padding(16.dp).weight(0.50f))
        }
    }
}

/*
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
*/
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Ejem18_holaJetpackComposeTheme {
        MiFuncionVisual()
    }
}
