package com.example.aad_mayo.sharePreferences.Alumno.domain

interface CalificacionRepository {
    fun guardarCalificacion(calificacion: Calificacion)
    fun obtenerCalificacionesPorAlumno(expediente: String): List<Calificacion>
    fun obtenerTodasCalificaciones(): List<Calificacion>
}