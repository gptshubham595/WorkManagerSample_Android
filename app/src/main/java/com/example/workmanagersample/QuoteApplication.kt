package com.example.workmanagersample

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class QuoteApplication : Application() {
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
}
