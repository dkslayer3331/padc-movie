package com.mhst.padc_movie_app.persistance.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mhst.padc_movie_app.data.vos.GenreVo
import com.mhst.padc_movie_app.data.vos.MovieVO

/**
 * Created by Moe Htet on 01,August,2020
 */
@Dao
interface GenreDao {
    @Query("select * from genres")
    fun getAllGenres() : LiveData<List<GenreVo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addGenres(movies : List<GenreVo>)

    @Query("delete from genres")
    fun deleteAllGeneres()

    @Transaction
    fun deleteInsert(genres: List<GenreVo>){
        deleteAllGeneres()
        addGenres(genres)
    }
}