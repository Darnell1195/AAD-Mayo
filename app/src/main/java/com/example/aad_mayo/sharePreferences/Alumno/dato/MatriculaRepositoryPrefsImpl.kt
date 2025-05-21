package com.example.aad_mayo.sharePreferences.Alumno.dato

import android.content.Context
import android.content.SharedPreferences
import com.example.aad_mayo.Room.Alumno.domain.Matricula
import com.example.aad_mayo.Room.Alumno.domain.MatriculaRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MatriculaRepositoryPrefsImpl(context: Context) : MatriculaRepository {
    private val prefs: SharedPreferences = context.getSharedPreferences("matriculas_prefs", Context.MODE_PRIVATE)
    private val gson = Gson()

    override fun guardarMatricula(matricula: Matricula) {
        val matriculas = obtenerTodasMatriculas().toMutableList()
        matriculas.removeAll { it.alumnoExpediente == matricula.alumnoExpediente }
        matriculas.add(matricula)
        prefs.edit().putString("matriculas", gson.toJson(matriculas)).apply()
    }

    override fun obtenerMatriculaPorAlumno(expediente: String): Matricula? {
        return obtenerTodasMatriculas().find { it.alumnoExpediente == expediente }
    }

    override fun obtenerTodasMatriculas(): List<Matricula> {
        val json = prefs.getString("matriculas", null) ?: return emptyList()
        val type = object : TypeToken<List<Matricula>>() {}.type
        return gson.fromJson(json, type)
    }
}