package com.mhst.padc_movie_app.data.models

import androidx.lifecycle.LiveData
import com.mhst.padc_movie_app.data.vos.MovieVO
import com.mhst.padc_movie_app.utils.API_KEY
import com.mhst.padc_movie_app.utils.NO_INTERNET_CONNECTION
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object MovieModelImpl : MovieModel,BaseModel() {

    override fun getAllMovies(onError: (String) -> Unit): LiveData<List<MovieVO>> {
        return mDb.movieDao().getAllPopularMovies()
    }

    override fun getMoviesAndSaveToDb(onSuccess: () -> Unit, onError: (String) -> Unit) {
        mApi.getPopularMovies(API_KEY)
            .map { it.movies }
            .flatMap{
                mDb.movieDao().deleteInsert(it)
                return@flatMap Observable.just(it)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

            },{
                onError(it.localizedMessage ?: NO_INTERNET_CONNECTION)
            })
    }

}