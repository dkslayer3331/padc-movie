package com.mhst.padc_movie_app.data.models

import android.graphics.Movie
import androidx.lifecycle.LiveData
import com.mhst.padc_movie_app.data.vos.*
import io.reactivex.Observable

interface MovieModel  {

    fun getAllMovies(onError: (String) -> Unit) : LiveData<List<MovieVO>>

    fun getMoviesAndSaveToDb(onSuccess: () -> Unit,onError : (String) -> Unit)

    fun getAllPersons(onError: (String) -> Unit) : LiveData<List<PersonVO>>

    fun getPeopleAndSaveToDb(onSuccess: () -> Unit,onError : (String) -> Unit)

    fun getAllGenres(onError: (String) -> Unit) : LiveData<List<GenreVo>>

    fun getGenresAndSaveToDb(onSuccess: () -> Unit,onError : (String) -> Unit)

    fun getMovieDetail(movieId : Int,onSuccess: (movie : MovieDetailVO) -> Unit,onError : (String) -> Unit)

    fun getVideo(movieId: Int,onSuccess: (video : VideoVO)-> Unit, onError: (String) -> Unit)

    fun getMoviesByGenres(genreId : Int,onSuccess: (movies : List<MovieVO>) -> Unit,onError : (String) -> Unit)

}