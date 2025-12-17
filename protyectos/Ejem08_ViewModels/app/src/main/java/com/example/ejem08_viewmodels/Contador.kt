package com.example.ejem08_viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Contador: ViewModel() {

    // Lista mutable de un tipo (en este caso de ints) siendo asi un objeto no relaccionado con la vista
    // por lo tanto al cambiar el actyvity hace que no se "cambie el valor" es decir que persista
    // De esta manera por ejemplo si bolteamos el movil el valor se mantiene (antes se perdia el valor)
    var contador = MutableLiveData<Int>(0)

    fun increment(){
        // si es nulo coje el balor por defecto que es 0 y luego suma 1
        //contador.value=(contador.value ?:0 )+1 // OPCION TERNARIA
        contador.value = contador.value?.plus(1)  // si es nulo coje el balor por defecto que es 0 y luego suma 1



    }
}
