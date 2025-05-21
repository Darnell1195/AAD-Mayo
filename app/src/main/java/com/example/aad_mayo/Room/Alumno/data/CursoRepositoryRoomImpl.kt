package com.example.aad_mayo.Room.Alumno.data

import com.example.aad_mayo.Room.Alumno.data.Entity.CursoEntity
import com.example.aad_mayo.Room.Alumno.domain.Curso
import com.example.aad_mayo.Room.Alumno.domain.CursoRepositoryRoom
import com.example.aad_mayo.Room.Curso.data.Dao.CursoDao

class CursoRepositoryRoomImpl(private val cursoDao: CursoDao) : CursoRepositoryRoom {
    override suspend fun guardarCurso(curso: Curso) {
        cursoDao.insertar(
            CursoEntity(
                id = curso.id,
                nombre = curso.nombre
            )
        )
    }

    override suspend fun obtenerCursoPorId(id: String): Curso? {
        return cursoDao.obtenerPorId(id)?.let {
            Curso(it.id, it.nombre)
        }
    }

    override suspend fun obtenerTodosCursos(): List<Curso> {
        return cursoDao.obtenerTodos().map {
            Curso(it.id, it.nombre)
        }
    }
}