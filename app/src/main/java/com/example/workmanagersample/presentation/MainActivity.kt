package com.example.workmanagersample.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.example.workmanagersample.R
import com.example.workmanagersample.presentation.viewModels.QuoteViewModel
import com.example.workmanagersample.presentation.worker.QuoteWorker
import dagger.hilt.android.AndroidEntryPoint
import java.util.concurrent.TimeUnit
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val quoteViewModel: QuoteViewModel by viewModels()

//    val request = OneTimeWorkRequestBuilder<QuoteWorker>().build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupWorker()
        initObserver()
    }

    private fun initObserver() {
        lifecycleScope.launch {
            quoteViewModel.quoteList.flowWithLifecycle(lifecycle, Lifecycle.State.STARTED).collect {
                println("Quote: $it")
            }
        }
    }

    private fun setupWorker() {
        val constrains = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
        val workRequest = PeriodicWorkRequest.Builder(QuoteWorker::class.java, 30, TimeUnit.MINUTES)
            .setConstraints(constrains)
            .build()
        WorkManager.getInstance(this).enqueue(workRequest)
    }
}
