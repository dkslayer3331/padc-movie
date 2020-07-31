package com.mhst.padc_movie_app.mvp.presenter

import com.mhst.padc_movie_app.mvp.view.BaseView

/**
 * Created by Moe Htet on 31,July,2020
 */

interface BasePresenter<T : BaseView> {

    fun initPresenter(view: T)

}