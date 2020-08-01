package com.mhst.padc_movie_app.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

/**
 * Created by Moe Htet on 01,August,2020
 */
class GenreWorker(context: Context, workerParams: WorkerParameters) :
    BaseWorker(context, workerParams) {
    override fun doWork(): Result {
        var result = Result.failure()
        model.getGenresAndSaveToDb(onSuccess = {result = Result.success()},onError = {result = Result.failure()})
        return result
    }
}