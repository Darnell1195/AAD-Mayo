package com.example.aad_mayo.sharePreferences.Alumno.domain

import com.example.aad_mayo.Room.Alumno.domain.Alumno
import com.example.aad_mayo.Room.Alumno.domain.Asignatura
import com.example.aad_mayo.Room.Alumno.domain.Curso
import com.example.aad_mayo.Room.Alumno.domain.Grupo

class informacionAlumno (
    val alumno: Alumno,
    val curso: Curso?,
    val grupo: Grupo?,
    val calificaciones: List<Pair<Asignatura, String>>
    )