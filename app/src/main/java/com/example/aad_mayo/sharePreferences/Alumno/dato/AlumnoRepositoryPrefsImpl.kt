package com.example.aad_mayo.sharePreferences.Alumno.dato

import android.content.Context
import android.content.SharedPreferences
import com.example.aad_mayo.sharePreferences.Alumno.domain.Alumno
import com.example.aad_mayo.sharePreferences.Alumno.domain.AlumnoRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class AlumnoRepositoryPrefsImpl(context: Context) : AlumnoRepository {
    private val prefs: SharedPreferences = context.getSharedPreferences("alumnos_prefs", Context.MODE_PRIVATE)
    private val gson = Gson()

    override fun guardarAlumno(alumno: Alumno) {
        val alumnos = obtenerTodosAlumnos().toMutableList()
        alumnos.removeAll { it.expediente == alumno.expediente }
        alumnos.add(alumno)
        prefs.edit().putString("alumnos", gson.toJson(alumnos)).apply()
    }

    override fun obtenerAlumnoPorExpediente(expediente: String): Alumno? {
        return obtenerTodosAlumnos().find { it.expediente == expediente }
    }

    override fun obtenerTodosAlumnos(): List<Alumno> {
        val json = prefs.getString("alumnos", null) ?: return emptyList()
        val type = object : TypeToken<List<Alumno>>() {}.type
        return gson.fromJson(json, type)
    }
}