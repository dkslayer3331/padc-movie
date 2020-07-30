package com.mhst.padc_movie_app.app

import android.app.Application
import com.mhst.padc_movie_app.data.models.MovieModelImpl

class MovieApp : Application() {

    override fun onCreate() {
        super.onCreate()
        MovieModelImpl.initDb(this)
    }

}