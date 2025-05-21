package com.example.aad_mayo.sharePreferences.Alumno.domain

interface MatriculaRepository {
    fun guardarMatricula(matricula: Matricula)
    fun obtenerMatriculaPorAlumno(expediente: String): Matricula?
    fun obtenerTodasMatriculas(): List<Matricula>
}