package com.example.aad_mayo.sharePreferences.Alumno.domain

class informacionAlumno (
    val alumno: Alumno,
    val curso: Curso?,
    val grupo: Grupo?,
    val calificaciones: List<Pair<Asignatura, String>>
    )