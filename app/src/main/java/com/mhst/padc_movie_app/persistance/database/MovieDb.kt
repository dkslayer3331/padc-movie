package com.mhst.padc_movie_app.persistance.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mhst.padc_movie_app.data.vos.GenreVo
import com.mhst.padc_movie_app.data.vos.MovieVO
import com.mhst.padc_movie_app.data.vos.PersonVO
import com.mhst.padc_movie_app.persistance.daos.GenreDao
import com.mhst.padc_movie_app.persistance.daos.MovieDao
import com.mhst.padc_movie_app.persistance.daos.PersonDao

@Database(entities = [MovieVO::class,PersonVO::class,GenreVo::class], version = 2, exportSchema = false)
    abstract class MovieDb : RoomDatabase() {
        companion object {
            val DB_NAME = "PADC_MOVIES.DB"
            var dbInstance: MovieDb? = null

            fun getDBInstance(context: Context): MovieDb {
                when (dbInstance) {
                    null -> {
                        dbInstance = Room.databaseBuilder(context, MovieDb::class.java, DB_NAME)
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build()
                    }
                }

                val i = dbInstance
                return i!!
            }
        }

        abstract fun movieDao(): MovieDao

        abstract fun personDao() : PersonDao

        abstract fun genreDao() : GenreDao
    }
