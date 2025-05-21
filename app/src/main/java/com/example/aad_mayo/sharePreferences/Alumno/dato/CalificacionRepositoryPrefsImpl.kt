package com.example.aad_mayo.sharePreferences.Alumno.dato

import android.content.Context
import android.content.SharedPreferences
import com.example.aad_mayo.Room.Alumno.domain.Calificacion
import com.example.aad_mayo.Room.Alumno.domain.CalificacionRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CalificacionRepositoryPrefsImpl(context: Context) : CalificacionRepository {
    private val prefs: SharedPreferences = context.getSharedPreferences("calificaciones_prefs", Context.MODE_PRIVATE)
    private val gson = Gson()

    override fun guardarCalificacion(calificacion: Calificacion) {
        val calificaciones = obtenerTodasCalificaciones().toMutableList()
        calificaciones.removeAll { it.alumnoExpediente == calificacion.alumnoExpediente && it.asignaturaId == calificacion.asignaturaId }
        calificaciones.add(calificacion)
        prefs.edit().putString("calificaciones", gson.toJson(calificaciones)).apply()
    }

    override fun obtenerCalificacionesPorAlumno(expediente: String): List<Calificacion> {
        return obtenerTodasCalificaciones().filter { it.alumnoExpediente == expediente }
    }

    override fun obtenerTodasCalificaciones(): List<Calificacion> {
        val json = prefs.getString("calificaciones", null) ?: return emptyList()
        val type = object : TypeToken<List<Calificacion>>() {}.type
        return gson.fromJson(json, type)
    }
}