package com.example.aad_mayo.Room.Alumno.domain

interface AlumnoRepository {
    suspend fun guardarAlumno(alumno: Alumno)
    suspend fun obtenerAlumnoPorExpediente(expediente: String): Alumno?
    suspend fun obtenerTodosAlumnos(): List<Alumno>
}