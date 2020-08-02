package com.mhst.padc_movie_app.data.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mhst.padc_movie_app.data.vos.*
import com.mhst.padc_movie_app.utils.DummyDatas

/**
 * Created by Moe Htet on 02,August,2020
 */
object MockMovieImpl : MovieModel {

    override fun getAllMovies(onError: (String) -> Unit): LiveData<List<MovieVO>> {
        val mutableLiveData = MutableLiveData<List<MovieVO>>()
        mutableLiveData.postValue(DummyDatas.getMovieList())
        return mutableLiveData
    }

    override fun getMoviesAndSaveToDb(onSuccess: () -> Unit, onError: (String) -> Unit) {

    }

    override fun getAllPersons(onError: (String) -> Unit): LiveData<List<PersonVO>> {
        val mutableLiveData = MutableLiveData<List<PersonVO>>()
        mutableLiveData.postValue(DummyDatas.getAllPeople())
        return mutableLiveData
    }

    override fun getPeopleAndSaveToDb(onSuccess: () -> Unit, onError: (String) -> Unit) {

    }

    override fun getAllGenres(onError: (String) -> Unit): LiveData<List<GenreVo>> {
        val mutableLiveData = MutableLiveData<List<GenreVo>>()
        mutableLiveData.postValue(DummyDatas.getAllGenres())
        return mutableLiveData
    }

    override fun getGenresAndSaveToDb(onSuccess: () -> Unit, onError: (String) -> Unit) {

    }

    override fun getMovieDetail(
        movieId: Int,
        onSuccess: (movie: MovieDetailVO) -> Unit,
        onError: (String) -> Unit
    ) {
        onSuccess(DummyDatas.getDummyDetail(movieId))
    }

    override fun getVideo(
        movieId: Int,
        onSuccess: (video: VideoVO) -> Unit,
        onError: (String) -> Unit
    ) {

    }

    override fun getMoviesByGenres(
        genreId: Int,
        onSuccess: (movies: List<MovieVO>) -> Unit,
        onError: (String) -> Unit
    ) {
        onSuccess(DummyDatas.getMovieList())
    }

    override fun changeFavStatus(personId: Long, isFav: Boolean, onSuccess: () -> Unit) {

    }
}