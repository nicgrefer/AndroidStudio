package com.example.ejem14_persistenciadb

import androidx.room.Dao
import androidx.room.Insert

@Dao
abstract class UsuarioDAo {

    @Insert
    abstract fun insert(usuario: Usuario)
}