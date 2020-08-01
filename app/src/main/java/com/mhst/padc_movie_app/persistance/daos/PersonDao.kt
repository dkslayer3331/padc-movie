package com.mhst.padc_movie_app.persistance.daos

import android.app.Person
import androidx.lifecycle.LiveData
import androidx.room.*
import com.mhst.padc_movie_app.data.vos.MovieVO
import com.mhst.padc_movie_app.data.vos.PersonVO

/**
 * Created by Moe Htet on 31,July,2020
 */
@Dao
interface PersonDao {

    @Query("select * from persons")
    fun getAllPerson() : LiveData<List<PersonVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPerson(movies : List<PersonVO>)

    @Query("delete from persons")
    fun deleteAllPeople()

    @Query("update persons set isFav = :fav where id = :id")
    fun changeFavStatus(id : Long,fav : Boolean)

    @Transaction
    fun deleteInsert(people: List<PersonVO>){
        deleteAllPeople()
        insertPerson(people)
    }

}