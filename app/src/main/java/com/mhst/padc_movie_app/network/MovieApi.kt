package com.mhst.padc_movie_app.network

import com.mhst.padc_movie_app.BuildConfig
import com.mhst.padc_movie_app.data.vos.MovieDetailVO
import com.mhst.padc_movie_app.network.responses.GenreListResponse
import com.mhst.padc_movie_app.network.responses.MovieListResponse
import com.mhst.padc_movie_app.network.responses.PopularPersonResponse
import com.mhst.padc_movie_app.network.responses.VideosResponsee
import com.mhst.padc_movie_app.utils.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET(GET_POPULAR_MOVIES)
    fun getPopularMovies(@Query("api_key")apiKey : String = BuildConfig.MOVIE_API_KEY) : Observable<MovieListResponse>

    @GET(GET_POPULAR_PERSONS)
    fun getPopularPerson(@Query("api_key")apiKey: String = BuildConfig.MOVIE_API_KEY) : Observable<PopularPersonResponse>

    @GET(GET_ALL_GENRES)
    fun getAllGenres(@Query("api_key")apiKey: String = BuildConfig.MOVIE_API_KEY) : Observable<GenreListResponse>

    @GET("movie/{MOVIE_ID}")
    fun getMovieDetail(
        @Path("MOVIE_ID") movieID: Int,
        @Query("api_key") apiKey: String = BuildConfig.MOVIE_API_KEY,
        @Query("append_to_response") appendToResponse: String = "credits") : Observable<MovieDetailVO>

    @GET(MOVIES_BY_GENRE)
    fun getMoviesByGenre(
        @Query("api_key") apiKey: String = BuildConfig.MOVIE_API_KEY,
        @Query("with_genres") genreId: Int
    ) : Observable<MovieListResponse>

    @GET("movie/{MOVIE_ID}/videos")
    fun getVideosById(
        @Path("MOVIE_ID") movieID: Int,
        @Query("api_key") apiKey: String = BuildConfig.MOVIE_API_KEY
    ) : Observable<VideosResponsee>

}