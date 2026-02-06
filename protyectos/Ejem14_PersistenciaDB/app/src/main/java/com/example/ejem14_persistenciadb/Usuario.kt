package com.example.ejem14_persistenciadb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuarios")
data class Usuario (@PrimaryKey(autoGenerate = true) var id:Int= 0,
                   @ColumnInfo val nombre:String,
                   @ColumnInfo(name = "edad") val edad:Int){

}