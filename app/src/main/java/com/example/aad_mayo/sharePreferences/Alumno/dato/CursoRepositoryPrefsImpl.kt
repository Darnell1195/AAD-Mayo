package com.example.aad_mayo.sharePreferences.Alumno.dato

import android.content.Context
import android.content.SharedPreferences
import com.example.aad_mayo.Room.Alumno.domain.Curso
import com.example.aad_mayo.Room.Alumno.domain.CursoRepositoryRoom
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CursoRepositoryPrefsImpl(context: Context) : CursoRepositoryRoom {
    private val prefs: SharedPreferences = context.getSharedPreferences("cursos_prefs", Context.MODE_PRIVATE)
    private val gson = Gson()

    override fun guardarCurso(curso: Curso) {
        val cursos = obtenerTodosCursos().toMutableList()
        cursos.removeAll { it.id == curso.id }
        cursos.add(curso)
        prefs.edit().putString("cursos", gson.toJson(cursos)).apply()
    }

    override fun obtenerCursoPorId(id: String): Curso? {
        return obtenerTodosCursos().find { it.id == id }
    }

    override fun obtenerTodosCursos(): List<Curso> {
        val json = prefs.getString("cursos", null) ?: return emptyList()
        val type = object : TypeToken<List<Curso>>() {}.type
        return gson.fromJson(json, type)
    }
}