package com.example.aad_mayo.Room.Calificacion.data.Dao

import androidx.room.*
import com.example.aad_mayo.Room.Alumno.data.Entity.CalificacionEntity

@Dao
interface CalificacionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(calificacion: CalificacionEntity)

    @Query("SELECT * FROM calificaciones WHERE id = :id")
    suspend fun obtenerPorId(id: String): CalificacionEntity?

    @Query("SELECT * FROM calificaciones")
    suspend fun obtenerTodos(): List<CalificacionEntity>
}