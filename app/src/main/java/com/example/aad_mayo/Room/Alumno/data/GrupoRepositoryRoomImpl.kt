package com.example.aad_mayo.Room.Alumno.data

import com.example.aad_mayo.Room.Alumno.data.Dao.GrupoDao
import com.example.aad_mayo.Room.Alumno.data.Entity.GrupoEntity
import com.example.aad_mayo.Room.Alumno.domain.Grupo
import com.example.aad_mayo.Room.Alumno.domain.GrupoRepository

class GrupoRepositoryRoomImpl(private val grupoDao: GrupoDao) : GrupoRepository {
    override suspend fun guardarGrupo(grupo: Grupo) {
        grupoDao.insertar(
            GrupoEntity(
                id = grupo.id,
                nombre = grupo.nombre,
                cursoId = grupo.cursoId
            )
        )
    }

    override suspend fun obtenerGrupoPorId(id: String): Grupo? {
        return grupoDao.obtenerPorId(id)?.let {
            Grupo(it.id, it.nombre, it.cursoId)
        }
    }

    override suspend fun obtenerTodosGrupos(): List<Grupo> {
        return grupoDao.obtenerTodos().map {
            Grupo(it.id, it.nombre, it.cursoId)
        }
    }
}