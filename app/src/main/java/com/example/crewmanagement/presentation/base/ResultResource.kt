package com.example.crewmanagement.presentation.base


sealed class ResultResource<out T>

data class SuccessResource<out T>(val data: T) : ResultResource<T>()

data class FailureResource(val error: Int) : ResultResource<Nothing>()

data class LoadingResource(val message: String? = null) : ResultResource<Nothing>()
