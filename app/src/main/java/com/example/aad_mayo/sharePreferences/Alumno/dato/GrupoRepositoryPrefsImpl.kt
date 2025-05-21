package com.example.aad_mayo.sharePreferences.Alumno.dato

import android.content.Context
import android.content.SharedPreferences
import com.example.aad_mayo.sharePreferences.Alumno.domain.Grupo
import com.example.aad_mayo.sharePreferences.Alumno.domain.GrupoRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class GrupoRepositoryPrefsImpl(context: Context) : GrupoRepository {
    private val prefs: SharedPreferences = context.getSharedPreferences("grupos_prefs", Context.MODE_PRIVATE)
    private val gson = Gson()

    override fun guardarGrupo(grupo: Grupo) {
        val grupos = obtenerTodosGrupos().toMutableList()
        grupos.removeAll { it.id == grupo.id }
        grupos.add(grupo)
        prefs.edit().putString("grupos", gson.toJson(grupos)).apply()
    }

    override fun obtenerGrupoPorId(id: String): Grupo? {
        return obtenerTodosGrupos().find { it.id == id }
    }

    override fun obtenerTodosGrupos(): List<Grupo> {
        val json = prefs.getString("grupos", null) ?: return emptyList()
        val type = object : TypeToken<List<Grupo>>() {}.type
        return gson.fromJson(json, type)
    }
}