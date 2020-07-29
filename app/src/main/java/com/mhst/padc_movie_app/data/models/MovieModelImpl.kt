package com.mhst.padc_movie_app.data.models

import com.mhst.padc_movie_app.data.vos.MovieVO
import com.mhst.padc_movie_app.utils.API_KEY
import io.reactivex.Observable

class MovieModelImpl : MovieModel, BaseModel() {

    override fun getMovies(onError: (String) -> Unit): Observable<List<MovieVO>> {
        return  mApi.getPopularMovies().map { it.movies }
    }
}