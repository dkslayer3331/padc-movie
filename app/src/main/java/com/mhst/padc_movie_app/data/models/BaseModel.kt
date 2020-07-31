package com.mhst.padc_movie_app.data.models

import android.content.Context
import com.mhst.padc_movie_app.network.MovieApi
import com.mhst.padc_movie_app.persistance.database.MovieDb
import com.mhst.padc_movie_app.utils.BASE_API_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseModel {

    protected var mApi : MovieApi

    protected lateinit var mDb : MovieDb

    init {
        val mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_API_URL)
            .client(mOkHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        mApi = retrofit.create(MovieApi::class.java)

    }

    fun initDb(context: Context){
        mDb = MovieDb.getDBInstance(context)
    }

}