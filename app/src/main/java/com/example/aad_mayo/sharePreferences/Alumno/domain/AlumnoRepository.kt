package com.example.aad_mayo.sharePreferences.Alumno.domain

import com.example.aad_mayo.Room.Alumno.domain.Alumno

interface AlumnoRepository {
    fun guardarAlumno(alumno: Alumno)
    fun obtenerAlumnoPorExpediente(expediente: String): Alumno?
    fun obtenerTodosAlumnos(): List<Alumno>
}