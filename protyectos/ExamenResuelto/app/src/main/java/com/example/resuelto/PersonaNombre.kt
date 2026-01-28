package com.example.resuelto

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PersonaNombre(var nombre:String=""): ViewModel() {

    var nombreLive = MutableLiveData<String>("")

    fun aniadirDato(dato:String=""){
        nombreLive.value= dato
        nombre=nombreLive.value.toString()
    }

}