package com.example.aad_mayo.sharePreferences.Alumno.domain

interface GrupoRepository {
    fun guardarGrupo(grupo: Grupo)
    fun obtenerGrupoPorId(id: String): Grupo?
    fun obtenerTodosGrupos(): List<Grupo>
}