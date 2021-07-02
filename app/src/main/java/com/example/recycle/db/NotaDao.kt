package com.example.recycle.db

import androidx.room.*

@Dao
interface NotaDao {
    @Query("SELECT * FROM Nota")
    suspend fun obtenerTodas():List<Nota>

    @Query("SELECT * FROM Nota WHERE id=:id")
    suspend fun getById(id:Int):Nota

    @Update
    suspend fun update(nota: Nota)

    @Insert
    suspend fun Insert(notas:List<Nota>)

    @Delete
    suspend fun delete(nota: Nota)

}