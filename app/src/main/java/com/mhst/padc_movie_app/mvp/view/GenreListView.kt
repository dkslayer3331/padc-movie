package com.mhst.padc_movie_app.mvp.view

import androidx.lifecycle.LifecycleOwner
import com.mhst.padc_movie_app.data.vos.MovieVO

/**
 * Created by Moe Htet on 01,August,2020
 */
interface GenreListView : BaseView {
    fun displayMoviesByGenre(movies : List<MovieVO>)
    fun navigateDetail(movieId : Int)
}