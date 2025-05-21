package com.example.aad_mayo.Room.Matricula.data.Dao

import androidx.room.*
import com.example.aad_mayo.Room.Alumno.data.Entity.MatriculaEntity

@Dao
interface MatriculaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(matricula: MatriculaEntity)

    @Query("SELECT * FROM matriculas WHERE id = :id")
    suspend fun obtenerPorId(id: String): MatriculaEntity?

    @Query("SELECT * FROM matriculas")
    suspend fun obtenerTodos(): List<MatriculaEntity>
}