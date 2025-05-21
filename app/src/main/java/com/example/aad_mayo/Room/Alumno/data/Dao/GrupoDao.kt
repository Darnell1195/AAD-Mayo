package com.example.aad_mayo.Room.Grupo.data.Dao

import androidx.room.*
import com.example.aad_mayo.Room.Alumno.data.Entity.GrupoEntity

@Dao
interface GrupoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(grupo: GrupoEntity)

    @Query("SELECT * FROM grupos WHERE id = :id")
    suspend fun obtenerPorId(id: String): GrupoEntity?

    @Query("SELECT * FROM grupos")
    suspend fun obtenerTodos(): List<GrupoEntity>
}