package com.mhst.padc_movie_app.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.mhst.padc_movie_app.data.models.MovieModel
import com.mhst.padc_movie_app.data.models.MovieModelImpl
import io.reactivex.Scheduler

/**
 * Created by Moe Htet on 31,July,2020
 */
abstract class BaseWorker(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams){

    val model : MovieModel = MovieModelImpl

}