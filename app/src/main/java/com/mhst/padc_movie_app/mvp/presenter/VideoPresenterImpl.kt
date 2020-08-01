package com.mhst.padc_movie_app.mvp.presenter

import android.util.Log
import com.mhst.padc_movie_app.data.models.MovieModelImpl
import com.mhst.padc_movie_app.mvp.view.VideoView


/**
 * Created by Moe Htet on 01,August,2020
 */
class VideoPresenterImpl : VideoPresenter,AbstractBasePresenter<VideoView>() {

    val model = MovieModelImpl

    override fun onUiReady(movieId: Int) {
        model.getVideo(movieId,onSuccess = {
            mView?.showVideo(it.key ?: "")
        },onError = {
            Log.d("errVideo",it)
        })
    }

}