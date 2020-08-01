package com.mhst.padc_movie_app.mvp.view

import com.mhst.padc_movie_app.data.vos.GenreVo
import com.mhst.padc_movie_app.data.vos.MovieVO
import com.mhst.padc_movie_app.data.vos.PersonVO

/**
 * Created by Moe Htet on 31,July,2020
 */
interface MainView : BaseView {
    fun displayPopularMovies(movies: List<MovieVO>)
    fun displayActors(actorList : List<PersonVO>)
    fun navigateToMovieDetails(movieId: Int)
    fun enableSwipeRefresh()
    fun disableSwipeRefresh()
    fun displayGenreList(genres : List<GenreVo>)
}