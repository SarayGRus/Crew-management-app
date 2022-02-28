package com.example.crewmanagement.presentation.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crewmanagement.data.ErrorHandler.DEFAULT_ERROR
import com.example.crewmanagement.domain.model.OompaLoompaListDomainResponse
import com.example.crewmanagement.domain.usecase.GetAllUseCase
import com.example.crewmanagement.presentation.base.BaseViewModel
import com.example.crewmanagement.presentation.base.FailureResource
import com.example.crewmanagement.presentation.base.LoadingResource
import com.example.crewmanagement.presentation.base.ResultResource
import com.example.crewmanagement.presentation.base.SuccessResource
import com.example.crewmanagement.utils.SingleEvent
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainActivityViewModel(
    private val getAllUseCase: GetAllUseCase
): BaseViewModel() {

    private val _getAllLiveData = MutableLiveData<ResultResource<OompaLoompaListDomainResponse>>()
    val getAllLiveData get() = _getAllLiveData as LiveData<ResultResource<OompaLoompaListDomainResponse>>

    private val _showToastLiveData = MutableLiveData<SingleEvent<Any>>()
    val showToastLiveData get() = _showToastLiveData as LiveData<SingleEvent<Any>>

    fun getAll() {
        _getAllLiveData.postValue(LoadingResource())
        viewModelScope.launch {
            kotlin.runCatching {
                getAllUseCase.execute(Unit).let { _getAllLiveData.postValue(SuccessResource(it))}
            }.onFailure {
                this@MainActivityViewModel._getAllLiveData.postValue(FailureResource(DEFAULT_ERROR))
            }
        }
    }

    fun showToastMessage(errorCode: Int) {
        val error = errorManager.getError(errorCode)
        _showToastLiveData.value = SingleEvent(error.description)
    }
}