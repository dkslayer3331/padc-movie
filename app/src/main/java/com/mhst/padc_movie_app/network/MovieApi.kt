package com.mhst.padc_movie_app.network

import com.mhst.padc_movie_app.network.responses.GenreListResponse
import com.mhst.padc_movie_app.network.responses.MovieListResponse
import com.mhst.padc_movie_app.network.responses.PopularPersonResponse
import com.mhst.padc_movie_app.utils.API_KEY
import com.mhst.padc_movie_app.utils.GET_ALL_GENRES
import com.mhst.padc_movie_app.utils.GET_POPULAR_MOVIES
import com.mhst.padc_movie_app.utils.GET_POPULAR_PERSONS
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET(GET_POPULAR_MOVIES)
    fun getPopularMovies(@Query("api_key")apiKey : String = API_KEY) : Observable<MovieListResponse>

    @GET(GET_POPULAR_PERSONS)
    fun getPopularPerson(@Query("api_key")apiKey: String = API_KEY) : Observable<PopularPersonResponse>

    @GET(GET_ALL_GENRES)
    fun getAllGenres(@Query("api_key")apiKey: String = API_KEY) : Observable<GenreListResponse>

}