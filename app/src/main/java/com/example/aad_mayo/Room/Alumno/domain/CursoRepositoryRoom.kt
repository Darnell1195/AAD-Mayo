package com.example.aad_mayo.Room.Alumno.domain

interface CursoRepositoryRoom {
    suspend fun guardarCurso(curso: Curso)
    suspend fun obtenerCursoPorId(id: String): Curso?
    suspend fun obtenerTodosCursos(): List<Curso>
}