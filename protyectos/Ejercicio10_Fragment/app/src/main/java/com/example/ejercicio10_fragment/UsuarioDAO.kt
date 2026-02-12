package com.example.ejercicio10_fragment

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
 abstract class UsuarioDAO {

    @Insert
    abstract fun insert(usuario: Usuario)

    @Query("SELECT * FROM usuarios")
    abstract fun getAll(): List<Usuario>

}