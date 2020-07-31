package com.mhst.padc_movie_app.mvp.presenter

import androidx.lifecycle.ViewModel
import com.mhst.padc_movie_app.mvp.view.BaseView

/**
 * Created by Moe Htet on 31,July,2020
 */
abstract class AbstractBasePresenter<T : BaseView> : BasePresenter<T>, ViewModel() {
    var mView: T? = null

    override fun initPresenter(view: T) {
        mView = view
    }
}