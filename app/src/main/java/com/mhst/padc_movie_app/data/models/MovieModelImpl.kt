package com.mhst.padc_movie_app.data.models

import androidx.lifecycle.LiveData
import com.mhst.padc_movie_app.data.vos.GenreVo
import com.mhst.padc_movie_app.data.vos.MovieDetailVO
import com.mhst.padc_movie_app.data.vos.MovieVO
import com.mhst.padc_movie_app.data.vos.PersonVO
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
        mApi.getPopularPerson(API_KEY)
            .map { it.result }
            .flatMap{
                mDb.personDao().deleteInsert(it)
                return@flatMap Observable.just(it)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

            },{
                onError(it.localizedMessage ?: NO_INTERNET_CONNECTION)
            })
    }

    override fun getAllPersons(onError: (String) -> Unit): LiveData<List<PersonVO>> {
        return mDb.personDao().getAllPerson()
    }

    override fun getPeopleAndSaveToDb(onSuccess: () -> Unit, onError: (String) -> Unit) {
        mApi.getPopularPerson(API_KEY)
            .map { it.result }
            .flatMap{
                mDb.personDao().deleteInsert(it)
                return@flatMap Observable.just(it)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

            },{
                onError(it.localizedMessage ?: NO_INTERNET_CONNECTION)
            })
    }

    override fun getAllGenres(onError: (String) -> Unit): LiveData<List<GenreVo>> {
        return mDb.genreDao().getAllGenres()
    }

    override fun getGenresAndSaveToDb(onSuccess: () -> Unit, onError: (String) -> Unit) {
        mApi.getAllGenres(API_KEY)
            .map { it.genres }
            .flatMap{
                mDb.genreDao().deleteInsert(it)
                return@flatMap Observable.just(it)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({},{
                onError(it.localizedMessage ?: NO_INTERNET_CONNECTION)
            })
    }

    override fun getMovieDetail(movieId: Int, onSuccess: (MovieDetailVO) -> Unit, onError: (String) -> Unit) {
        mApi.getMovieDetail(movieId, API_KEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ onSuccess(it) },{
                onError(it.localizedMessage ?: NO_INTERNET_CONNECTION)
            })
    }

}