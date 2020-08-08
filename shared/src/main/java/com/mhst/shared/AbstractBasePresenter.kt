package com.mhst.shared

import androidx.lifecycle.ViewModel

/**
 * Created by Moe Htet on 31,July,2020
 */
abstract class AbstractBasePresenter<T : BaseView> : BasePresenter<T>, ViewModel() {
    var mView: T? = null

    override fun initPresenter(view: T) {
        mView = view
    }
}