package com.mhst.padc_movie_app.mvp.presenter

import com.mhst.padc_movie_app.mvp.view.DetailView

/**
 * Created by Moe Htet on 01,August,2020
 */
interface DetailPresenter : BasePresenter<DetailView> {
    fun onUiReady(movieId : Int)
}