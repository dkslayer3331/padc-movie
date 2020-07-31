package com.mhst.padc_movie_app.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import com.mhst.padc_movie_app.delegate.TapDelegate
import com.mhst.padc_movie_app.mvp.view.MainView

/**
 * Created by Moe Htet on 31,July,2020
 */
interface MainPresenter : TapDelegate,BasePresenter<MainView> {
    fun onUiReady(lifecycleOwner: LifecycleOwner)
    fun onSwipeRefresh(lifecycleOwner: LifecycleOwner)
}