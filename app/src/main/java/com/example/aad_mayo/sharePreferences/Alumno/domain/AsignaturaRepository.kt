package com.example.aad_mayo.sharePreferences.Alumno.domain

import com.example.aad_mayo.Room.Alumno.domain.Asignatura

interface AsignaturaRepository {
    fun guardarAsignatura(asignatura: Asignatura)
    fun obtenerAsignaturaPorId(id: String): Asignatura?
    fun obtenerTodasAsignaturas(): List<Asignatura>
}