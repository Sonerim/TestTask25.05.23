package com.zakorchook.testtask250523.data

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.zakorchook.testtask250523.data.db.UpdateDbWorker

class BootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_BOOT_COMPLETED) {
            WorkManager.getInstance(context).enqueue(
                OneTimeWorkRequestBuilder<UpdateDbWorker>().build()
            )
        }
    }
}