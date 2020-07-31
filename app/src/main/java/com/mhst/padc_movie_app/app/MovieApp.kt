package com.mhst.padc_movie_app.app

import android.app.Application
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.mhst.padc_movie_app.data.models.MovieModelImpl
import com.mhst.padc_movie_app.workers.PopularMovieWorker

class MovieApp : Application() {

    override fun onCreate() {
        super.onCreate()
        MovieModelImpl.initDb(this)
        oneTimePopularMovies()
    }

    private fun oneTimePopularMovies(){
        val getEventsWorkRequest = OneTimeWorkRequest
            .Builder(PopularMovieWorker::class.java)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getEventsWorkRequest)
    }

}