package com.example.ejem14_persistencia

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuario")
data class Usuario(@PrimaryKey(autoGenerate = true) var id:Int = 0,
                   @ColumnInfo(name = "nombre") val nombre:String,
                   @ColumnInfo(name = "edad") val edad:Int) {


    override fun toString(): String {
        return "Usuario(nombre='$nombre', edad=$edad)"
    }
}
