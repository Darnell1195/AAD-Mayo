package com.example.aad_mayo.Room.Alumno.data.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cursos")
data class CursoEntity(
    @PrimaryKey val id: String,
    val nombre: String,

)