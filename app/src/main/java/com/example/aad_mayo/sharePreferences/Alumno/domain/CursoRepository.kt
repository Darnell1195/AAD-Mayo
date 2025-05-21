package com.example.aad_mayo.sharePreferences.Alumno.domain

interface CursoRepository {
    fun guardarCurso(curso: Curso)
    fun obtenerCursoPorId(id: String): Curso?
    fun obtenerTodosCursos(): List<Curso>
}