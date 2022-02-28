package com.example.crewmanagement.data.ErrorHandler

import android.content.Context
import javax.inject.Inject

class ErrorMapper @Inject constructor(val context: Context) : ErrorMapperSource {

    override fun getErrorString(errorId: Int): String {
        return context.getString(errorId)
    }
}
