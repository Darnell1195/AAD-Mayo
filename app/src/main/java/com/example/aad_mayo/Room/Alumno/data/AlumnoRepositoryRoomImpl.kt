package com.example.aad_mayo.Room.Alumno.data

import com.example.aad_mayo.Room.Alumno.data.Dao.AlumnoDao
import com.example.aad_mayo.Room.Alumno.data.Entity.AlumnoEntity
import com.example.aad_mayo.Room.Alumno.domain.Alumno
import com.example.aad_mayo.Room.Alumno.domain.AlumnoRepository

class AlumnoRepositoryRoomImpl(private val alumnoDao: AlumnoDao) : AlumnoRepository {

    override suspend fun guardarAlumno(alumno: Alumno) {
        alumnoDao.insertar(
            AlumnoEntity(
                expediente = alumno.expediente,
                nombre = alumno.nombre,
                apellidos = alumno.apellidos,
                anioNacimiento = alumno.anioNacimiento
            )
        )
    }

    override suspend fun obtenerAlumnoPorExpediente(expediente: String): Alumno? {
        return alumnoDao.obtenerPorExpediente(expediente)?.let {
            Alumno(it.expediente, it.nombre, it.apellidos, it.anioNacimiento)
        }
    }

    override suspend fun obtenerTodosAlumnos(): List<Alumno> {
        return alumnoDao.obtenerTodos().map {
            Alumno(it.expediente, it.nombre, it.apellidos, it.anioNacimiento)
        }
    }
}