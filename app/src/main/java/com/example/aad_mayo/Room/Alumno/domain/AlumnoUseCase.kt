package com.example.aad_mayo.Room.Alumno.domain

import com.example.aad_mayo.Room.Alumno.data.AlumnoRepositoryRoomImpl
import com.example.aad_mayo.Room.Alumno.data.CursoRepositoryRoomImpl
import com.example.aad_mayo.Room.Alumno.data.GrupoRepositoryRoomImpl
import com.example.aad_mayo.Room.Alumno.data.MatriculaRepositoryRoomImpl
import com.example.aad_mayo.Room.Alumno.data.AsignaturaRepositoryRoomImpl
import com.example.aad_mayo.Room.Alumno.data.CalificacionRepositoryRoomImpl

suspend fun obtenerInfoDetalladaAlumnoRoom(
    expediente: String,
    alumnoRepo: AlumnoRepositoryRoomImpl,
    cursoRepo: CursoRepositoryRoomImpl,
    grupoRepo: GrupoRepositoryRoomImpl,
    matriculaRepo: MatriculaRepositoryRoomImpl,
    asignaturaRepo: AsignaturaRepositoryRoomImpl,
    calificacionRepo: CalificacionRepositoryRoomImpl
): String {
    val alumno = alumnoRepo.obtenerAlumnoPorExpediente(expediente)
    val matricula = matriculaRepo.obtenerMatriculaPorAlumno(expediente)
    val curso = matricula?.cursoId?.let { cursoRepo.obtenerCursoPorId(it) }
    val grupo = matricula?.grupoId?.let { grupoRepo.obtenerGrupoPorId(it) }

    val asignaturas = curso?.let { c ->
        asignaturaRepo.obtenerTodasAsignaturas().filter { it.cursoId == c.id }
    } ?: emptyList()

    val calificaciones = asignaturas.map { asig ->
        val calif = calificacionRepo.obtenerTodasCalificaciones()
            .find { it.alumnoExpediente == expediente && it.asignaturaId == asig.id }
        "${asig.nombre}: ${calif?.calificacion ?: "Sin nota"}"
    }

    return """
        Alumno: ${alumno?.nombre ?: "No disponible"} ${alumno?.apellidos ?: ""}
        Expediente: $expediente
        Curso: ${curso?.nombre ?: "No disponible"}
        Grupo: ${grupo?.nombre ?: "No disponible"}
        Asignaturas y calificaciones:
        ${if (calificaciones.isNotEmpty()) calificaciones.joinToString("\n") else "No disponible"}
    """.trimIndent()
}