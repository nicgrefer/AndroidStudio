package com.example.ejerciciofragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContadorViewModel: ViewModel() {

    private val _contador = MutableLiveData<Int>(0)

    val contador: LiveData<Int> get() = _contador

    fun sumar() {
        _contador.value = (_contador.value ?: 0) + 1
    }

}