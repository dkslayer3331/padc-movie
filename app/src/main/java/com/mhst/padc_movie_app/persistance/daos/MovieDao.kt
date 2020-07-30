package com.mhst.padc_movie_app.persistance.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mhst.padc_movie_app.data.vos.MovieVO

@Dao
interface MovieDao {

    @Query("select * from movies")
    fun getAllPopularMovies() : LiveData<MovieVO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies : List<MovieVO>)

    @Query("delete from movies")
    fun deleteAllMovies()

    @Transaction
    fun deleteInsert(movies: List<MovieVO>){
        deleteAllMovies()
        insertMovies(movies)
    }

}