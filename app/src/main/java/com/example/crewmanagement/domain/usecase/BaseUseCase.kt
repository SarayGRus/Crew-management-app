package com.example.crewmanagement.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class BaseUseCase<I, O> {
    protected open val dispatcher: CoroutineDispatcher = Dispatchers.IO

    protected abstract suspend fun useCaseFunction(input: I): O

    suspend fun execute(input: I): O {
        return withContext(dispatcher) { useCaseFunction(input) }
    }
}