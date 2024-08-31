package com.example.workmanagersample

import android.app.Application
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class QuoteApplication() : Application(), Configuration.Provider {

    @Inject
    lateinit var workerFactory: HiltWorkerFactory

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    fun initialize() {
//        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
//        val dataBase = QuoteDatabase.getDatabase(applicationContext)
//        val quoteRepository: QuoteManagerRepo =
//            QuoteManagerRepoImpl(quoteService, dataBase, applicationContext)
    }

    override val workManagerConfiguration: Configuration
        get() = Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()
}
