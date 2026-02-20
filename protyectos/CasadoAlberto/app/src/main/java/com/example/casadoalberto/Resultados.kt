package com.example.casadoalberto

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase
import androidx.room.Update

@Entity(tableName = "resultado")
data class Resultado(@PrimaryKey(autoGenerate = true) var id:Int= 0,
                   @ColumnInfo(name = "valor") val valor:String= "")


@Dao
abstract class ResultadoDAO {
    @Query("SELECT * FROM resultado")
    abstract fun listar(): List<Resultado?>?
    @Query("SELECT * FROM resultado WHERE id = :id")
    abstract fun recuperarUsuario(id: Int): Resultado?
    @Insert
    abstract fun insertar(p: Resultado)
    @Delete
    abstract fun eliminar(p: Resultado)
    @Update
    abstract fun actualizar(p: Resultado)
}

@Database(entities = [Resultado::class], version= 1)
public abstract class BD : RoomDatabase() {
    public abstract fun resultadoDAO(): ResultadoDAO?}