package com.mhst.padc_movie_app.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import com.mhst.padc_movie_app.delegate.TapDelegate
import com.mhst.padc_movie_app.mvp.view.GenreListView

/**
 * Created by Moe Htet on 01,August,2020
 */
interface GenrePresenter : BasePresenter<GenreListView>,TapDelegate {
    fun onUiReady(lifecycleOwner: LifecycleOwner,movieId : Int)
}