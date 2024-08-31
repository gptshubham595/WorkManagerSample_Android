package com.example.workmanagersample.domain.usecase

import com.example.workmanagersample.domain.models.ResultEntity
import com.example.workmanagersample.domain.repository.QuoteManagerRepo
import com.example.workmanagersample.utils.BaseUseCase
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetQuotesUseCase @Inject constructor(private val quoteManagerRepo: QuoteManagerRepo) :
    BaseUseCase<Int, Flow<List<ResultEntity>>>() {
    override suspend fun run(params: Int): Flow<List<ResultEntity>> = flow {
        quoteManagerRepo.getQuotes(params)?.let {
            emit(it.results)
        }
    }
}
