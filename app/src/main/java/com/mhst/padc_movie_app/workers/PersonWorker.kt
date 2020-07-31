package com.mhst.padc_movie_app.workers

import android.content.Context
import androidx.work.WorkerParameters

/**
 * Created by Moe Htet on 31,July,2020
 */
class PersonWorker(context: Context, workerParams: WorkerParameters) :
    BaseWorker(context, workerParams) {

    var result = Result.failure()
    override fun doWork(): Result{
        model.getMoviesAndSaveToDb(onSuccess = {  result = Result.success()  },onError = { result = Result.failure() })
        return result
    }

}