package com.mhst.shared

/**
 * Created by Moe Htet on 31,July,2020
 */

interface BasePresenter<T : BaseView> {

    fun initPresenter(view: T)

}