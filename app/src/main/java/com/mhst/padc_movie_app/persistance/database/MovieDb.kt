package com.mhst.padc_movie_app.persistance.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mhst.padc_movie_app.data.vos.MovieVO
import com.mhst.padc_movie_app.persistance.daos.MovieDao

@Database(entities = [MovieVO::class], version = 1, exportSchema = false)
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
    }