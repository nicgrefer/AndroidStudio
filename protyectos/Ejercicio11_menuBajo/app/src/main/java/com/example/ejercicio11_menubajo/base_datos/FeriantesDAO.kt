package com.example.ejercicio11_menubajo.base_datos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
abstract class FeriantesDAO {

    @Insert
    abstract fun insert(feriante: Feriantes)
    @Query("SELECT * FROM feriantes")
    abstract fun getAll(): List<Feriantes>
    @Delete
    abstract fun delete(feriante: Feriantes)
}