package com.example.aad_mayo.Room.Alumno.data.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "alumnos")
data class AlumnoEntity(
    @PrimaryKey val expediente: String,
    val nombre: String,
    val apellidos: String,
    val anioNacimiento: String
)