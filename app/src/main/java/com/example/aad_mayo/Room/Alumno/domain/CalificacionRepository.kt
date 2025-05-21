package com.example.aad_mayo.Room.Alumno.domain

interface CalificacionRepository {
    suspend fun guardarCalificacion(calificacion: Calificacion)
    suspend fun obtenerCalificacionPorId(id: String): Calificacion?
    suspend fun obtenerTodasCalificaciones(): List<Calificacion>
}