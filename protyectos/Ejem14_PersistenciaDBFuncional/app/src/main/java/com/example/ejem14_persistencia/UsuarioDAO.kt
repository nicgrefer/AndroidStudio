package com.example.ejem14_persistencia

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
abstract class UsuarioDAO {

    @Insert
    abstract fun insertarUsuario(usuario: Usuario)

    @Query("DELETE FROM usuario WHERE id = :i")
    abstract fun eliminarUsuario(i: Int)


    @Query("SELECT * FROM usuario WHERE id = :i")
    abstract fun recuperarUsuario(i: Int): Usuario?

    @Query("SELECT * FROM usuario")
    abstract fun listaUsuarios(): List<Usuario>

    /*@Delete
    abstract fun eliminarUsuario2(usuario: Usuario)*/
}