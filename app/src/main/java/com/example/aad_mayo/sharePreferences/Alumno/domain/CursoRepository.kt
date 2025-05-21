package com.example.aad_mayo.sharePreferences.Alumno.domain

import com.example.aad_mayo.Room.Alumno.domain.Curso

interface CursoRepository {
    fun guardarCurso(curso: Curso)
    fun obtenerCursoPorId(id: String): Curso?
    fun obtenerTodosCursos(): List<Curso>
}