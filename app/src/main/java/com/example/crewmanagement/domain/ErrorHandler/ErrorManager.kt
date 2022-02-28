package com.example.crewmanagement.domain.ErrorHandler

import com.example.crewmanagement.data.ErrorHandler.ErrorMapper
import javax.inject.Inject
import com.example.crewmanagement.data.ErrorHandler.Error

/**
 * Created by AhmedEltaher
 */

class ErrorManager @Inject constructor(private val errorMapper: ErrorMapper) : ErrorUseCase {
    override fun getError(errorCode: Int): Error {
        return Error(code = errorCode, description = "")
    }
}
