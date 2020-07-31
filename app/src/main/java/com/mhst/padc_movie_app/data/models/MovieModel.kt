package com.mhst.padc_movie_app.data.models

import android.graphics.Movie
import androidx.lifecycle.LiveData
import com.mhst.padc_movie_app.data.vos.MovieVO
import io.reactivex.Observable

interface MovieModel  {

    fun getAllMovies(onError: (String) -> Unit) : LiveData<List<MovieVO>>


    fun getMoviesAndSaveToDb(onSuccess: () -> Unit,onError : (String) -> Unit)

}