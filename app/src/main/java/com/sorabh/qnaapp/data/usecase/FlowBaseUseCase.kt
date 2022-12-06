package com.sorabh.qnaapp.data.usecase

import com.sorabh.qnaapp.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

abstract class FlowBaseUseCase<in P, R> {
    abstract suspend fun getResponse(params: P): Result<R>
    private suspend fun getDate(params: P): Flow<Result<R>> = flow {
        emit(Result.Loading())
        try {
            emit(getResponse(params))
        } catch (e: Exception) {
            emit(Result.Error(500, e.message.toString()))
        }
    }
    suspend operator fun invoke(params: P) = getDate(params)
}

suspend operator fun <R> FlowBaseUseCase<Unit,R>.invoke(params:Unit) = this(params)

