package com.example.ejercicio11_menubajo.base_datos

import androidx.room.Database

@Database(entities = [Feriantes::class, Gastos::class], version = 1)
abstract class BD {
}