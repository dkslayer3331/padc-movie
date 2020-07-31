package com.mhst.padc_movie_app.workers

import android.content.Context
import androidx.work.WorkerParameters

/**
 * Created by Moe Htet on 31,July,2020
 */
class PopularMovieWorker(context: Context, workerParams: WorkerParameters) :
    BaseWorker(context, workerParams) {
    override fun doWork(): Result {
        var result = Result.failure()
        model.getMoviesAndSaveToDb(onSuccess = {
            result = Result.success()
        },onError = {
            result = Result.failure()
        })
        return result
    }

}