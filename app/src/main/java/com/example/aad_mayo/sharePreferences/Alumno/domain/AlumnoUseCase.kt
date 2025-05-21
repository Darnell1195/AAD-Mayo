package com.example.aad_mayo.sharePreferences.Alumno.domain

import com.example.aad_mayo.sharePreferences.Alumno.dato.*

fun obtenerInfoDetalladaAlumno(
    expediente: String,
    alumnoRepo: AlumnoRepositoryPrefsImpl,
    cursoRepo: CursoRepositoryPrefsImpl,
    grupoRepo: GrupoRepositoryPrefsImpl,
    matriculaRepo: MatriculaRepositoryPrefsImpl,
    asignaturaRepo: AsignaturaRepositoryPrefsImpl,
    calificacionRepo: CalificacionRepositoryPrefsImpl
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