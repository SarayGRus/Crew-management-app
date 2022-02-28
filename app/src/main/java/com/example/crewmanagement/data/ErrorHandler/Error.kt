package com.example.crewmanagement.data.ErrorHandler

/**
 * Created by AhmedEltaher
 */

class Error(val code: Int, val description: String) {
    constructor(exception: Exception) : this(code = DEFAULT_ERROR, description = exception.message
            ?: "")
}

const val DEFAULT_ERROR = -3
