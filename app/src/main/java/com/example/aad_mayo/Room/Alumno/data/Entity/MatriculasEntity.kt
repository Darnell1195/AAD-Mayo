package com.example.aad_mayo.Room.Alumno.data.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "matriculas")
data class MatriculaEntity(
    @PrimaryKey val id: String,
    val alumnoId: String,
    val grupoId: String,
    val fecha: String
)