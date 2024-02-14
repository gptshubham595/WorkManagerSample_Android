package com.example.workmanagersample.core

import android.content.Context
import com.example.workmanagersample.data.api.QuoteService
import com.example.workmanagersample.data.db.QuoteDatabase
import com.example.workmanagersample.data.models.QuoteListData
import com.example.workmanagersample.domain.models.QuoteListEntity
import com.example.workmanagersample.domain.repository.QuoteManagerRepo
import com.example.workmanagersample.domain.toDomain
import com.example.workmanagersample.utils.NetworkUtils
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class QuoteManagerRepoImpl @Inject constructor(
    private val quoteService: QuoteService,
    private val quoteDatabase: QuoteDatabase,
    @ApplicationContext private val applicationContext: Context,
) : QuoteManagerRepo {

    override suspend fun getQuotes(page: Int): QuoteListEntity? {
        if (NetworkUtils.isInternetAvailable(applicationContext)) {
            // api
            val result = quoteService.getQuotes(page)
            if (result?.body() != null) {
                quoteDatabase.getQuoteDao().addQuotes(result.body()!!.results)
                return result.body()?.toDomain()
            }
        } else {
            // db
            val quotes = quoteDatabase.getQuoteDao().getQuotes()
            val quoteList = QuoteListData(1, 1, 1, quotes, 1, 1)
            return quoteList.toDomain()
        }
        return null
    }

    override suspend fun getQuotesBackground(): QuoteListEntity? {
        val random = (0..10).random()
        val result = quoteService.getQuotes(random)
        result?.body()?.let {
            it?.results?.let { it1 -> quoteDatabase.getQuoteDao().addQuotes(it1) }
        }
        return result.body()?.toDomain()
    }
}
