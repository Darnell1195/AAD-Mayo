package com.example.aad_mayo.sharePreferences.Alumno.dato

import android.content.Context
import android.content.SharedPreferences
import com.example.aad_mayo.Room.Alumno.domain.Asignatura
import com.example.aad_mayo.Room.Alumno.domain.AsignaturaRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class AsignaturaRepositoryPrefsImpl(context: Context) : AsignaturaRepository {
    private val prefs: SharedPreferences = context.getSharedPreferences("asignaturas_prefs", Context.MODE_PRIVATE)
    private val gson = Gson()

    override fun guardarAsignatura(asignatura: Asignatura) {
        val asignaturas = obtenerTodasAsignaturas().toMutableList()
        asignaturas.removeAll { it.id == asignatura.id }
        asignaturas.add(asignatura)
        prefs.edit().putString("asignaturas", gson.toJson(asignaturas)).apply()
    }

    override fun obtenerAsignaturaPorId(id: String): Asignatura? {
        return obtenerTodasAsignaturas().find { it.id == id }
    }

    override fun obtenerTodasAsignaturas(): List<Asignatura> {
        val json = prefs.getString("asignaturas", null) ?: return emptyList()
        val type = object : TypeToken<List<Asignatura>>() {}.type
        return gson.fromJson(json, type)
    }
}