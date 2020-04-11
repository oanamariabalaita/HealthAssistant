package com.example.healthassistant.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.coroutineScope

class DatabaseWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {
    override suspend fun doWork(): Result = coroutineScope {
        try {
//            applicationContext.assets.open().use { inputStream ->
//                JsonReader(inputStream.reader()).use { jsonReader ->
//                    val objType = object : TypeToken<List<>>() {}.type
//                    val plantList: List<> = Gson().fromJson(jsonReader, objType)
//
//                    val database = AppDatabase.getInstance(applicationContext)
//                    database.plantDao().insertAll()
//
            Result.success()
//                }
//            }
        } catch (ex: Exception) {
            Log.e(TAG, "Error seeding database", ex)
            Result.failure()
        }
    }

    companion object {
        private val TAG = DatabaseWorker::class.java.simpleName
    }
}