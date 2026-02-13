package com.example.ejerrepasoexamen.base_datos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "feriantes")
data class Feriantes(@PrimaryKey(autoGenerate = true) var id: Int =0,
                    @ColumnInfo var nombre: String)
