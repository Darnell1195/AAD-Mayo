package com.example.aad_mayo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.aad_mayo.sharePreferences.Alumno.dato.*
import com.example.aad_mayo.sharePreferences.Alumno.domain.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val alumnoRepo = AlumnoRepositoryPrefsImpl(this)
        val cursoRepo = CursoRepositoryPrefsImpl(this)
        val grupoRepo = GrupoRepositoryPrefsImpl(this)
        val matriculaRepo = MatriculaRepositoryPrefsImpl(this)
        val asignaturaRepo = AsignaturaRepositoryPrefsImpl(this)
        val calificacionRepo = CalificacionRepositoryPrefsImpl(this)

        // Datos DAM con expedientes de 3 dígitos
        val alumnos = listOf(
            Alumno("001", "Carlos", "Ruiz", 2003),
            Alumno("002", "Lucía", "Santos", 2004),
            Alumno("003", "Miguel", "Gómez", 2003),
            Alumno("004", "Elena", "Martínez", 2004)
        )
        alumnos.forEach { alumnoRepo.guardarAlumno(it) }

        val curso = Curso("DAM1", "1º DAM")
        cursoRepo.guardarCurso(curso)

        val grupo = Grupo("G1", "A")
        grupoRepo.guardarGrupo(grupo)

        val matriculas = listOf(
            Matricula("001", "DAM1", "G1"),
            Matricula("002", "DAM1", "G1"),
            Matricula("003", "DAM1", "G1"),
            Matricula("004", "DAM1", "G1")
        )
        matriculas.forEach { matriculaRepo.guardarMatricula(it) }

        val asignaturas = listOf(
            Asignatura("AS1", "Programación", "DAM1"),
            Asignatura("AS2", "Bases de Datos", "DAM1"),
            Asignatura("AS3", "Entornos de Desarrollo", "DAM1"),
            Asignatura("AS4", "Lenguajes de Marcas", "DAM1")
        )
        asignaturas.forEach { asignaturaRepo.guardarAsignatura(it) }

        val calificaciones = listOf(
            Calificacion("001", "AS1", "7.5"),
            Calificacion("001", "AS2", "8.0"),
            Calificacion("001", "AS3", "9.0"),
            Calificacion("001", "AS4", "7.0"),
            Calificacion("002", "AS1", "8.5"),
            Calificacion("002", "AS2", "7.5"),
            Calificacion("002", "AS3", "8.0"),
            Calificacion("002", "AS4", "9.0"),
            Calificacion("003", "AS1", "6.0"),
            Calificacion("003", "AS2", "7.0"),
            Calificacion("003", "AS3", "6.5"),
            Calificacion("003", "AS4", "7.5"),
            Calificacion("004", "AS1", "9.0"),
            Calificacion("004", "AS2", "8.5"),
            Calificacion("004", "AS3", "9.5"),
            Calificacion("004", "AS4", "8.0")
        )
        calificaciones.forEach { calificacionRepo.guardarCalificacion(it) }

        val expediente = "001"
        val alumnoLoaded = alumnoRepo.obtenerAlumnoPorExpediente(expediente)
        val matriculaLoaded = matriculaRepo.obtenerMatriculaPorAlumno(expediente)
        val cursoLoaded = matriculaLoaded?.cursoId?.let { cursoRepo.obtenerCursoPorId(it) }
        val grupoLoaded = matriculaLoaded?.grupoId?.let { grupoRepo.obtenerGrupoPorId(it) }

        val asignaturasAlumno = cursoLoaded?.let { c ->
            asignaturaRepo.obtenerTodasAsignaturas().filter { it.cursoId == c.id }
        } ?: emptyList()

        val calificacionesAlumno = asignaturasAlumno.map { asig ->
            val calif = calificacionRepo.obtenerTodasCalificaciones()
                .find { it.alumnoExpediente == expediente && it.asignaturaId == asig.id }
            "${asig.nombre}: ${calif?.calificacion ?: "Sin nota"}"
        }

        val info = """
            Alumno: ${alumnoLoaded?.nombre ?: "No disponible"} ${alumnoLoaded?.apellidos ?: ""}
            Expediente: $expediente
            Curso: ${cursoLoaded?.nombre ?: "No disponible"}
            Grupo: ${grupoLoaded?.nombre ?: "No disponible"}
            Asignaturas y calificaciones:
            ${if (calificacionesAlumno.isNotEmpty()) calificacionesAlumno.joinToString("\n") else "No disponible"}
        """.trimIndent()

        Log.d("MainActivity", "Info estudiante:\n$info")
    }
}