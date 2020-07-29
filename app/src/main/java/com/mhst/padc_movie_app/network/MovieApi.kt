package com.mhst.padc_movie_app.network

import com.mhst.padc_movie_app.models.vos.MovieListResponse
import com.mhst.padc_movie_app.utils.GET_POPULAR_MOVIES
import retrofit2.http.GET

interface MovieApi {

    @GET(GET_POPULAR_MOVIES)
    fun getPopularMovies() : MovieListResponse



}