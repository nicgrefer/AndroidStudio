package com.example.ejercicio10_fragment

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuarios")
data class Usuario(@PrimaryKey(autoGenerate = true) var id: Int = 0,
                   @ColumnInfo var user: String,
                   @ColumnInfo var code: String)
