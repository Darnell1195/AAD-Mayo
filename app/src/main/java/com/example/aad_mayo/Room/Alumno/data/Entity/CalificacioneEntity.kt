package com.example.aad_mayo.Room.Alumno.data.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "calificaciones")
data class CalificacionEntity(
    @PrimaryKey val id: String,
    val alumnoId: String,
    val asignaturaId: String,
    val nota: Double
)