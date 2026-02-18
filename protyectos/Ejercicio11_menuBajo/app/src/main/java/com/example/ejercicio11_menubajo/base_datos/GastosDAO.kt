package com.example.ejercicio11_menubajo.base_datos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
abstract class GastosDAO {

    @Insert
    abstract fun insert(gastos: Gastos)
    @Query("SELECT * FROM gastos")
    abstract fun getAll(): List<Gastos>
    @Delete
    abstract fun delete(gastos: Gastos)

}