package com.mhst.padc_movie_app.mvp.presenter

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.mhst.padc_movie_app.data.models.MovieModelImpl
import com.mhst.padc_movie_app.mvp.view.MainView
import io.reactivex.Observable

/**
 * Created by Moe Htet on 31,July,2020
 */
class MainPresenterImpl : MainPresenter,AbstractBasePresenter<MainView>() {

    var model = MovieModelImpl

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        getAllDataForRvs(lifecycleOwner)
    }

    override fun onSwipeRefresh(lifecycleOwner: LifecycleOwner) {
        getAllDataForRvs(lifecycleOwner)
    }

    override fun onTap(id: Int) {
        mView?.navigateToMovieDetails(id)
    }

    private fun getAllDataForRvs(lifecycleOwner: LifecycleOwner){
        mView?.enableSwipeRefresh()
        model.getAllMovies {
            mView?.disableSwipeRefresh()
            Log.d("err",it)
        }.observe(lifecycleOwner, Observer {
            mView?.displayPopularMovies(it)
        })
        model.getAllPersons {
            Log.d("err",it)
        }.observe(lifecycleOwner, Observer {
            mView?.displayActors(it)
        })
    }

}