package com.mhst.padc_movie_app.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import com.mhst.padc_movie_app.data.models.MovieModel
import com.mhst.padc_movie_app.data.models.MovieModelImpl
import com.mhst.padc_movie_app.mvp.view.GenreListView
import com.mhst.shared.AbstractBasePresenter

/**
 * Created by Moe Htet on 01,August,2020
 */
class GenrePresenterImpl : GenrePresenter,
    AbstractBasePresenter<GenreListView>() {

     var model : MovieModel = MovieModelImpl

    override fun onUiReady(lifecycleOwner: LifecycleOwner, movieId: Int) {
            model.getMoviesByGenres(movieId,onSuccess = {
                mView?.displayMoviesByGenre(it.toMutableList())
            },onError = {

            })
    }

    override fun onTap(id: Int) {
        mView?.navigateDetail(id)
    }
}