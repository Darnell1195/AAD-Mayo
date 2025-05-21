package com.example.aad_mayo.Room.Asignatura.data.Dao

import androidx.room.*
import com.example.aad_mayo.Room.Asignatura.data.AsignaturaEntity

@Dao
interface AsignaturaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(asignatura: AsignaturaEntity)

    @Query("SELECT * FROM asignaturas WHERE id = :id")
    suspend fun obtenerPorId(id: String): AsignaturaEntity?

    @Query("SELECT * FROM asignaturas")
    suspend fun obtenerTodos(): List<AsignaturaEntity>
}