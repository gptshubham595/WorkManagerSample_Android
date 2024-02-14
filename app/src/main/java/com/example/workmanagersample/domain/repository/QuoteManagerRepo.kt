package com.example.workmanagersample.domain.repository

import com.example.workmanagersample.domain.models.QuoteListEntity

interface QuoteManagerRepo {
    suspend fun getQuotes(page: Int): QuoteListEntity?

    suspend fun getQuotesBackground(): QuoteListEntity?
}
