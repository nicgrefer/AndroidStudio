package com.example.ejem18_holajetpackcompose

import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiFuncionVisual()
            /* Ejem18_HolaJetPackComposeTheme {
                 Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                     Greeting(
                         name = "Android",
                         modifier = Modifier.padding(innerPadding)
                     )
                 }
             }*/
        }
    }
}

@Composable
fun MiFuncionVisual()
{
    var usuarios = remember { mutableStateListOf<Usuario>(
        Usuario("Juan",true,20, "Valladolid"),
        Usuario("Maria",false,21, "Burgos"),
        Usuario("Pedro",true,22,"Leon")
    ) }



    var contador by remember { mutableIntStateOf(0) }
    var edad by remember { mutableIntStateOf(0) }
    var nombre by remember { mutableStateOf("") }
    var sexo by remember { mutableStateOf("Hombre") }
    var ciudad by remember {mutableStateOf("")}
    var usuario: Usuario
    var habilitarGuardarUsuario by remember { mutableStateOf(false) }

    Column {
        Text(text="Hola JetPack Compose",modifier=Modifier.padding(5.dp))
        Row (modifier=Modifier
            .padding(5.dp)
            .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically )  {
            Text(text="Nombre:",modifier=Modifier
                .padding(5.dp)
                .weight(0.30f))
            TextField(placeholder =
                { Text(text="Escribe tu nombre") }
                , value = ""+nombre, onValueChange = {
                    nombre=it
                }, modifier=Modifier
                    .padding(5.dp)
                    .weight(0.70f))
        }
        Row (modifier=Modifier
            .padding(5.dp)
            .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically )  {
            Text(text="Edad:",modifier=Modifier
                .padding(5.dp)
                .weight(0.30f))
            TextField(placeholder =
                { Text(text="Escribe la edad") }
                , value = edad.toString(), onValueChange = {
                    edad=it.toIntOrNull() ?: 0
                }, modifier=Modifier
                    .padding(5.dp)
                    .weight(0.70f))
        }
        Row (modifier=Modifier
            .padding(5.dp)
            .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically )  {
            Text(text="Sexo:",modifier=Modifier
                .padding(5.dp)
                .weight(0.20f))
            RadioButton(selected = sexo=="Hombre", onClick = {  sexo="Hombre" }, modifier=Modifier
                .padding(5.dp)
                .weight(0.10f))
            Text(text="Hombre",modifier=Modifier
                .padding(5.dp)
                .weight(0.25f))
            RadioButton(selected = sexo=="Mujer", onClick = { sexo="Mujer" }, modifier=Modifier
                .padding(5.dp)
                .weight(0.10f))
            Text(text="Mujer",modifier=Modifier
                .padding(5.dp)
                .weight(0.25f))
        }

        Row (modifier=Modifier
            .padding(5.dp)
            .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically )  {
            Text(text="Ciudad nacimiento:",modifier=Modifier
                .padding(5.dp)
                .weight(0.20f))
            Text(text=ciudad,modifier=Modifier
                .padding(5.dp)
                .weight(0.20f))
            desplegable()
        }
        Button(
            enabled = habilitarGuardarUsuario,
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth(),
            onClick = {
                usuario= Usuario(nombre,sexo=="Hombre",edad,ciudad)
                usuarios.add(usuario)
                Log.d("depurando",usuario.toString())
            } ,
        ) { Text(text = "Guardar usuario") }
        Row (modifier=Modifier
            .padding(5.dp)
            .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically )  {
            Text(text= "Contador: $contador",modifier=Modifier
                .padding(5.dp)
                .weight(0.25f))
            Button(onClick = {
                contador++

            }, enabled = true, modifier=Modifier
                .padding(5.dp)
                .weight(0.50f)) {
                Row{
                    //Image(painter = painterResource(id = R.drawable.outline_123_24), contentDescription = "Contador")
                    Text(text="Pulsar contador")
                }
            }
        }
        Row (modifier=Modifier
            .padding(5.dp)
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        )  {
            Switch(modifier=Modifier
                .padding(5.dp)
                .weight(0.25f),
                checked = !habilitarGuardarUsuario,
                onCheckedChange = { habilitarGuardarUsuario=!habilitarGuardarUsuario })
            Text(text="Habilitar contador",modifier=Modifier
                .padding(5.dp)
                .weight(0.25f))
        }
        Surface(modifier=Modifier.fillMaxWidth(),
            color= androidx.compose.ui.graphics.Color.LightGray,
            shape = RoundedCornerShape(12.dp),
            tonalElevation = 4.dp){

            LazyColumn {
                items(usuarios.size) { index ->
                    val usuario=usuarios[index]
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                nombre = usuario.nombre
                                edad = usuario.edad
                                sexo = if (usuario.hombre) "Hombre" else "Mujer"
                                ciudad=usuario.ciudad
                            },
                        verticalAlignment = Alignment.CenterVertically){
                        Text(text = "Nombre: ${usuario.nombre}, " +
                                "Sexo: ${if(usuario.hombre) "Hombre" else "Mujer"}" +
                                " Edad: ${usuario.edad}",
                            modifier = Modifier
                                .padding(5.dp)
                                .weight(0.75f),
                        )
                        IconButton(modifier = Modifier.padding(5.dp), onClick = {
                            usuarios.removeAt(usuarios.indexOf(usuario))
                        }) { Icon(Icons.Default.Delete, contentDescription = "Borrar",tint=Color.DarkGray) }
                    }
                    HorizontalDivider(modifier = Modifier
                        .fillMaxWidth(0.80f)
                        .height(4.dp)
                        .padding(5.dp),
                        color = androidx.compose.ui.graphics.Color.DarkGray)
                }
            }
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
}*/

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    /* Ejem18_HolaJetPackComposeTheme {
         Greeting("Android")
     }*/
    MiFuncionVisual()
}

@Composable
fun desplegable()
{
    var desplegado by remember { mutableStateOf(false) }
    Box {
        Button(onClick = { desplegado = true })
        {
            Text("Mostrar ciudades")
        }
        DropdownMenu(expanded = desplegado,
            onDismissRequest = {desplegado=false}){
            DropdownMenuItem(text={Text("Valladolid")}, onClick = {desplegado=false})
            DropdownMenuItem(text={Text("Zamora")}, onClick = {desplegado=false})
            DropdownMenuItem(text={Text("Burgos")}, onClick = {desplegado=false})
            DropdownMenuItem(text={Text("León")}, onClick = {desplegado=false})
        }
    }
}