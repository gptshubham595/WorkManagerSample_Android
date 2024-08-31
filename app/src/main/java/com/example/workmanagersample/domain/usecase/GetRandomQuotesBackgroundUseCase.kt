package com.example.workmanagersample.domain.usecase

import com.example.workmanagersample.domain.models.ResultEntity
import com.example.workmanagersample.domain.repository.QuoteManagerRepo
import com.example.workmanagersample.utils.BaseUseCase
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Singleton

class GetRandomQuotesBackgroundUseCase @Inject constructor(
    private val quoteManagerRepo: QuoteManagerRepo
) :
    BaseUseCase<Unit, Flow<List<ResultEntity>>>() {
    override suspend fun run(params: Unit): Flow<List<ResultEntity>> = flow {
        quoteManagerRepo.getQuotesBackground()?.let {
            emit(it.results)
        }
    }
}
