package com.mhst.padc_movie_app.network

import com.mhst.padc_movie_app.data.vos.MovieListResponse
import com.mhst.padc_movie_app.utils.API_KEY
import com.mhst.padc_movie_app.utils.GET_POPULAR_MOVIES
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET(GET_POPULAR_MOVIES)
    fun getPopularMovies(@Query("api_key")apiKey : String = API_KEY) : Observable<MovieListResponse>

}