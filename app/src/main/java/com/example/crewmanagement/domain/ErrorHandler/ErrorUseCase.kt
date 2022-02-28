package com.example.crewmanagement.domain.ErrorHandler

import com.example.crewmanagement.data.ErrorHandler.Error

interface ErrorUseCase {
    fun getError(errorCode: Int): Error
}
