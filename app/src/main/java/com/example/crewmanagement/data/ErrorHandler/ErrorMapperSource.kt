package com.example.crewmanagement.data.ErrorHandler

interface ErrorMapperSource {
    fun getErrorString(errorId: Int): String
}
