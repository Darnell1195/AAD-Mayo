package com.example.aad_mayo.Room.Curso.data.Dao

import androidx.room.*
import com.example.aad_mayo.Room.Alumno.data.Entity.CursoEntity

@Dao
interface CursoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(curso: CursoEntity)

    @Query("SELECT * FROM cursos WHERE id = :id")
    suspend fun obtenerPorId(id: String): CursoEntity?

    @Query("SELECT * FROM cursos")
    suspend fun obtenerTodos(): List<CursoEntity>
}