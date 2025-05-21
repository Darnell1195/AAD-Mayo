package com.example.aad_mayo.Room.Alumno.data.Dao

import androidx.room.*
import com.example.aad_mayo.Room.Alumno.data.Entity.AlumnoEntity

@Dao
interface AlumnoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(alumno: AlumnoEntity)

    @Query("SELECT * FROM alumnos WHERE expediente = :expediente")
    suspend fun obtenerPorExpediente(expediente: String): AlumnoEntity?

    @Query("SELECT * FROM alumnos")
    suspend fun obtenerTodos(): List<AlumnoEntity>
}