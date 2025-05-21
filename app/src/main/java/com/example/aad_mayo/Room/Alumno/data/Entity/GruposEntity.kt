package com.example.aad_mayo.Room.Alumno.data.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "grupos")
data class GrupoEntity(
    @PrimaryKey val id: String,
    val nombre: String,
    val cursoId: String
)