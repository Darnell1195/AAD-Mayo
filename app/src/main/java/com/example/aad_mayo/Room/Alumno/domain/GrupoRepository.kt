package com.example.aad_mayo.Room.Alumno.domain

interface GrupoRepository {
    fun guardarGrupo(grupo: Grupo)
    fun obtenerGrupoPorId(id: String): Grupo?
    fun obtenerTodosGrupos(): List<Grupo>
}