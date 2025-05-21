package com.example.aad_mayo.Room.Alumno.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.aad_mayo.Room.Alumno.data.Dao.AlumnoDao
import com.example.aad_mayo.Room.Alumno.data.Entity.AlumnoEntity
import com.example.aad_mayo.Room.Asignatura.data.AsignaturaEntity
import com.example.aad_mayo.Room.Alumno.data.Entity.CalificacionEntity
import com.example.aad_mayo.Room.Alumno.data.Entity.CursoEntity
import com.example.aad_mayo.Room.Alumno.data.Entity.GrupoEntity
import com.example.aad_mayo.Room.Alumno.data.Entity.MatriculaEntity
import com.example.aad_mayo.Room.Asignatura.data.Dao.AsignaturaDao
import com.example.aad_mayo.Room.Calificacion.data.Dao.CalificacionDao
import com.example.aad_mayo.Room.Curso.data.Dao.CursoDao
import com.example.aad_mayo.Room.Grupo.data.Dao.GrupoDao
import com.example.aad_mayo.Room.Matricula.data.Dao.MatriculaDao

@Database(
    entities = [
        AlumnoEntity::class,
        CursoEntity::class,
        GrupoEntity::class,
        MatriculaEntity::class,
        AsignaturaEntity::class,
        CalificacionEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun alumnoDao(): AlumnoDao
    abstract fun cursoDao(): CursoDao
    abstract fun grupoDao(): GrupoDao
    abstract fun matriculaDao(): MatriculaDao
    abstract fun asignaturaDao(): AsignaturaDao
    abstract fun calificacionDao(): CalificacionDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}