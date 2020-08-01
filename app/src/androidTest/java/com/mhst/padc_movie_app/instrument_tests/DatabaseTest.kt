package com.mhst.padc_movie_app.instrument_tests

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.mhst.padc_movie_app.data.vos.GenreVo
import com.mhst.padc_movie_app.data.vos.MovieVO
import com.mhst.padc_movie_app.data.vos.PersonVO
import com.mhst.padc_movie_app.persistance.daos.GenreDao
import com.mhst.padc_movie_app.persistance.daos.MovieDao
import com.mhst.padc_movie_app.persistance.daos.PersonDao
import com.mhst.padc_movie_app.persistance.database.MovieDb
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Moe Htet on 01,August,2020
 */
@RunWith(AndroidJUnit4ClassRunner::class)
class DatabaseTest {

    private lateinit var db : MovieDb

    private lateinit var personDao: PersonDao

    private lateinit var movieDao: MovieDao

    private lateinit var genreDao: GenreDao

    private fun getMovieList() : List<MovieVO>{
        val list = mutableListOf<MovieVO>()
        for(i in 1..5L){
            list.add(
                MovieVO(i,1.5f,20,false,
                    "", "lang $i",
                    "title $i", listOf(),"title $i",3.4f,"","")
            )
        }
        return  list
    }

    private fun getPeople() : List<PersonVO>{
        val list = mutableListOf<PersonVO>()
        for(i in 1..5L){
            list.add(
                PersonVO(i,"name $i","",false)
            )
        }
        return  list
    }

    private fun getAllGenres() : List<GenreVo>{
        val list = mutableListOf<GenreVo>()
        for(i in 1..5L){
            list.add(
                GenreVo(i.toInt(),"name $i")
            )
        }
        return  list
    }

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context,MovieDb::class.java
        ).build()
        personDao = db.personDao()
        movieDao = db.movieDao()
        genreDao = db.genreDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun insertMovies(){
        movieDao.insertMovies(getMovieList())
        assert(movieDao.getAllPopularMovies().value?.size == getMovieList().size)
    }

    @Test
    fun insertPeople(){
        personDao.insertPerson(getPeople())
        assert(personDao.getAllPerson().value?.size == getPeople().size)
    }

    @Test
    fun insertGenres(){
        genreDao.addGenres(getAllGenres())
        assert(genreDao.getAllGenres().value?.size == getAllGenres().size)
    }


}