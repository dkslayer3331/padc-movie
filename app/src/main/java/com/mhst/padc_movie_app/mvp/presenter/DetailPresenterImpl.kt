package com.mhst.padc_movie_app.mvp.presenter

import android.util.Log
import com.mhst.padc_movie_app.data.models.MovieModelImpl
import com.mhst.padc_movie_app.mvp.view.DetailView

/**
 * Created by Moe Htet on 01,August,2020
 */
class DetailPresenterImpl : DetailPresenter,AbstractBasePresenter<DetailView>() {

    private val model = MovieModelImpl

    override fun onUiReady(movieId: Int) {
        model.getMovieDetail(movieId,onError = {
            Log.d("errDetail",it)
        },onSuccess = {
            mView?.showDetail(it)
        })
    }
}