package com.example.aad_mayo.sharePreferences.Alumno.domain

interface AlumnoRepository {
    fun guardarAlumno(alumno: Alumno)
    fun obtenerAlumnoPorExpediente(expediente: String): Alumno?
    fun obtenerTodosAlumnos(): List<Alumno>
}