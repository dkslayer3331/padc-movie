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

    override fun onTapFav(personId: Long, fav: Boolean) {
        model.changeFavStatus(personId,fav,onSuccess = {})
    }

    private fun getAllDataForRvs(lifecycleOwner: LifecycleOwner){
       // mView?.enableSwipeRefresh()

        model.getAllPersons {
            Log.d("errPersonCall",it)
        }.observe(lifecycleOwner, Observer {
            Log.d("personInPresenter",it.size.toString())
            mView?.displayActors(it)
        })

        model.getAllMovies {
           // mView?.disableSwipeRefresh()
            Log.d("err",it)
        }.observe(lifecycleOwner, Observer {
            mView?.displayPopularMovies(it)
        })

        model.getAllGenres {
            Log.d("genreErr",it)
        }.observe(lifecycleOwner, Observer {
            Log.d("sizeOfGenres",it.size.toString())
            mView?.displayGenreList(it)
        })

    }

}