package com.mhst.padc_movie_app.mvp.presenter

import com.mhst.padc_movie_app.mvp.view.VideoView

/**
 * Created by Moe Htet on 01,August,2020
 */
interface VideoPresenter : BasePresenter<VideoView> {
    fun onUiReady(movieId : Int)
}