package com.example.ejem14_persistencia

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Usuario::class], version = 1)
public abstract class BD : RoomDatabase() {
    public abstract fun usuarioDao(): UsuarioDAO?
}