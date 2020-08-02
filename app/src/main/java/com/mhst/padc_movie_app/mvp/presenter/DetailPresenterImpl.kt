package com.mhst.padc_movie_app.mvp.presenter

import android.util.Log
import com.mhst.padc_movie_app.data.models.MovieModel
import com.mhst.padc_movie_app.data.models.MovieModelImpl
import com.mhst.padc_movie_app.mvp.view.DetailView

/**
 * Created by Moe Htet on 01,August,2020
 */
class DetailPresenterImpl : DetailPresenter,AbstractBasePresenter<DetailView>() {

     var model : MovieModel = MovieModelImpl

    override fun onUiReady(movieId: Int) {
       getMovieDetail(movieId)
    }

    fun getMovieDetail(movieId: Int){
        mView?.showSwipeRefresh()
        model.getMovieDetail(movieId,onError = {
            mView?.hideSwipeRefresh()
            Log.d("errDetail",it)
        },onSuccess = {
            mView?.hideSwipeRefresh()
            mView?.showDetail(it)
        })
    }

    override fun onSwipeRefresh(movieId: Int) {
        getMovieDetail(movieId)
    }
}