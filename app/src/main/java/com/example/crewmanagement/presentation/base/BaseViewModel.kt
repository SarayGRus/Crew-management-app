package com.example.crewmanagement.presentation.base

import androidx.lifecycle.ViewModel
import com.example.crewmanagement.domain.ErrorHandler.ErrorManager
import javax.inject.Inject

abstract class BaseViewModel : ViewModel() {
    @Inject
    lateinit var errorManager: ErrorManager
}
