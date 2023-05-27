package com.zakorchook.testtask250523.data.db

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class UpdateDbWorker  @AssistedInject constructor(
    @Assisted val appContext: Context,
    @Assisted val workerParams: WorkerParameters,
    private val historyDao: HistoryDao):
       CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result {
        historyDao.insertItem(HistoryEntity(System.currentTimeMillis()))
        return Result.success()
    }
}