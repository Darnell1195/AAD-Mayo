package com.example.aad_mayo.Room.Asignatura.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "asignaturas")
data class AsignaturaEntity(
    @PrimaryKey val id: String,
    val nombre: String,
    val cursoId: String
)