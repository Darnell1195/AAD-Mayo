package com.example.aad_mayo.Room.Alumno.domain

interface AsignaturaRepository {
    suspend fun guardarAsignatura(asignatura: Asignatura)
    suspend fun obtenerAsignaturaPorId(id: String): Asignatura?
    suspend fun obtenerTodasAsignaturas(): List<Asignatura>
}