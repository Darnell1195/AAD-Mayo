package com.example.aad_mayo.Room.Alumno.data

import com.example.aad_mayo.Room.Alumno.data.Dao.MatriculaDao
import com.example.aad_mayo.Room.Alumno.data.Entity.MatriculaEntity
import com.example.aad_mayo.Room.Alumno.domain.Matricula
import com.example.aad_mayo.Room.Alumno.domain.MatriculaRepository

class MatriculaRepositoryRoomImpl(private val matriculaDao: MatriculaDao) : MatriculaRepository {
    override fun guardarMatricula(matricula: Matricula) {
        matriculaDao.insertar(
            MatriculaEntity(
                alumnoExpediente = matricula.alumnoExpediente,
                cursoId = matricula.cursoId,
                grupoId = matricula.grupoId
            )
        )
    }

    override fun obtenerMatriculaPorAlumno(expediente: String): Matricula? {
        return matriculaDao.obtenerPorAlumno(expediente)?.let {
            Matricula(it.alumnoExpediente, it.cursoId, it.grupoId)
        }
    }

    override fun obtenerTodasMatriculas(): List<Matricula> {
        return matriculaDao.obtenerTodos().map {
            Matricula(it.alumnoExpediente, it.cursoId, it.grupoId)
        }
    }
}