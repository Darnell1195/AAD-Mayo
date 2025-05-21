package com.example.aad_mayo.Room.Alumno.data

import com.example.aad_mayo.Room.Alumno.data.Entity.CalificacionEntity
import com.example.aad_mayo.Room.Alumno.domain.Calificacion
import com.example.aad_mayo.Room.Alumno.domain.CalificacionRepository
import com.example.aad_mayo.Room.Calificacion.data.Dao.CalificacionDao

class CalificacionRepositoryRoomImpl(private val calificacionDao: CalificacionDao) : CalificacionRepository {
    override suspend fun guardarCalificacion(calificacion: Calificacion) {
        calificacionDao.insertar(
            CalificacionEntity(
                id = "${calificacion.alumnoExpediente}_${calificacion.asignaturaId}",
                alumnoId = calificacion.alumnoExpediente,
                asignaturaId = calificacion.asignaturaId,
                nota = calificacion.calificacion.toDoubleOrNull() ?: 0.0
            )
        )
    }

    override suspend fun obtenerCalificacionPorId(id: String): Calificacion? {
        return calificacionDao.obtenerPorId(id)?.let {
            Calificacion(
                alumnoExpediente = it.alumnoId,
                asignaturaId = it.asignaturaId,
                calificacion = it.nota.toString()
            )
        }
    }

    override suspend fun obtenerTodasCalificaciones(): List<Calificacion> {
        return calificacionDao.obtenerTodos().map {
            Calificacion(
                alumnoExpediente = it.alumnoId,
                asignaturaId = it.asignaturaId,
                calificacion = it.nota.toString()
            )
        }
    }
}