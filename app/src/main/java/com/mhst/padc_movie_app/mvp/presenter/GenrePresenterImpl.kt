package com.mhst.padc_movie_app.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import com.mhst.padc_movie_app.mvp.view.GenreListView

/**
 * Created by Moe Htet on 01,August,2020
 */
class GenrePresenterImpl : GenrePresenter,AbstractBasePresenter<GenreListView>() {
    override fun onUiReady(lifecycleOwner: LifecycleOwner, movieId: Int) {

    }
}