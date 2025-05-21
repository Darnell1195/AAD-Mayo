package com.example.aad_mayo.sharePreferences.Alumno.domain

interface AsignaturaRepository {
    fun guardarAsignatura(asignatura: Asignatura)
    fun obtenerAsignaturaPorId(id: String): Asignatura?
    fun obtenerTodasAsignaturas(): List<Asignatura>
}