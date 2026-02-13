package com.example.ejerrepasoexamen.base_datos

import androidx.room.Database

@Database(entities = [FeriantesDAO::class, GastosDAO::class], version = 1)
public  abstract class BD {
}