package com.example.camposcarbajosara

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase

@Entity(tableName = "resultado")
data class Resultado(@PrimaryKey(autoGenerate = true) var id:Int = 0,
                     @ColumnInfo(name = "resultado") val resultado:String = "") {
    // no es necesario porque solo hay un elemento, pero podemos crear un toString para
    // luego imprimir lo que queramos en el adapter
    override fun toString(): String {
        return resultado
    }
}
// al ser abstract clases, podemos tener el dao junto con nuestra data class
// así podemos gestionarlo todo a la vez
// solo necesitamos insertar y recuperar todo
@Dao
abstract class ResultadoDAO {
    @Query("SELECT * FROM resultado")
    abstract fun listar(): List<Resultado>
    @Insert
    abstract fun insertar(p: Resultado)
}

// nuestra database solo tiene que gestionar una clase/tabla, asi que para acceso fácil,
// la podemos dejar aquí
// También podría ir en su propia clase
@Database(entities = [Resultado::class], version = 1)
public abstract class BD : RoomDatabase() {
    public abstract fun resultadoDao(): ResultadoDAO
}