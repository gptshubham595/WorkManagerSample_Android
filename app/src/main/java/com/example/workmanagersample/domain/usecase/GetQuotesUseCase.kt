package com.example.workmanagersample.domain.usecase

import com.example.workmanagersample.domain.models.ResultEntity
import com.example.workmanagersample.domain.repository.QuoteManagerRepo
import com.example.workmanagersample.utils.BaseUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val workManagerRepo: QuoteManagerRepo) :
    BaseUseCase<Int, Flow<List<ResultEntity>>>() {
    override suspend fun run(params: Int): Flow<List<ResultEntity>> = flow {
        workManagerRepo.getQuotes(params)?.let {
            emit(it.results)
        }
    }
}
