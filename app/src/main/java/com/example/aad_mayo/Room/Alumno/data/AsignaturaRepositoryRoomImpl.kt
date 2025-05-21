package com.example.aad_mayo.Room.Alumno.data

import com.example.aad_mayo.Room.Asignatura.data.AsignaturaEntity
import com.example.aad_mayo.Room.Asignatura.data.Dao.AsignaturaDao
import com.example.aad_mayo.Room.Alumno.domain.Asignatura
import com.example.aad_mayo.Room.Alumno.domain.AsignaturaRepository

class AsignaturaRepositoryRoomImpl(private val asignaturaDao: AsignaturaDao) : AsignaturaRepository {
    override suspend fun guardarAsignatura(asignatura: Asignatura) {
        asignaturaDao.insertar(
            AsignaturaEntity(
                id = asignatura.id,
                nombre = asignatura.nombre,
                cursoId = asignatura.cursoId
            )
        )
    }

    override suspend fun obtenerAsignaturaPorId(id: String): Asignatura? {
        return asignaturaDao.obtenerPorId(id)?.let {
            Asignatura(it.id, it.nombre, it.cursoId)
        }
    }

    override suspend fun obtenerTodasAsignaturas(): List<Asignatura> {
        return asignaturaDao.obtenerTodos().map {
            Asignatura(it.id, it.nombre, it.cursoId)
        }
    }
}