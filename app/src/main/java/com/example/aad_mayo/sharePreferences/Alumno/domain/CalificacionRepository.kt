package com.example.aad_mayo.sharePreferences.Alumno.domain

import com.example.aad_mayo.Room.Alumno.domain.Calificacion

interface CalificacionRepository {
    fun guardarCalificacion(calificacion: Calificacion)
    fun obtenerCalificacionesPorAlumno(expediente: String): List<Calificacion>
    fun obtenerTodasCalificaciones(): List<Calificacion>
}