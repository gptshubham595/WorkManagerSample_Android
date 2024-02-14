package com.example.workmanagersample.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

abstract class BaseUseCase<in Params, out Result> where Result : Any? {
    abstract suspend fun run(params: Params): Result

    operator fun invoke(
        scope: CoroutineScope,
        params: Params,
        onSuccess: (Result) -> Unit,
        onFailure: (Throwable) -> Unit
    ) {
        scope.launch {
            try {
                val result = async {
                    run(params)
                }.await()
                onSuccess(result)
            } catch (e: Throwable) {
                onFailure(e)
            }
        }
    }
}
