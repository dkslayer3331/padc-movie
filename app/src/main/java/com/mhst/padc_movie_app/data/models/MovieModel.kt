package com.mhst.padc_movie_app.data.models

import android.graphics.Movie
import com.mhst.padc_movie_app.data.vos.MovieVO
import io.reactivex.Observable

interface MovieModel  {

    fun getMovies(onError : (String) -> Unit) : Observable<List<MovieVO>>

}