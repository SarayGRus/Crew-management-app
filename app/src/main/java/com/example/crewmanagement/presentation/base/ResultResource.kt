package com.example.crewmanagement.presentation.base


sealed class ResultResource<out T>

data class SuccessResource<out T>(val data: T) : ResultResource<T>()

data class FailureResource(val error: Throwable?, val message: String?) : ResultResource<Nothing>()

data class LoadingResource(val message: String? = null) : ResultResource<Nothing>()
