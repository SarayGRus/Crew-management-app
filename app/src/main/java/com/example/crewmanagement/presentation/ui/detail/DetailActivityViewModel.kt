package com.example.crewmanagement.presentation.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.crewmanagement.data.ErrorHandler.DEFAULT_ERROR
import com.example.crewmanagement.domain.model.OompaLoompaDomain
import com.example.crewmanagement.domain.model.OompaLoompaListDomainResponse
import com.example.crewmanagement.domain.usecase.GetDetailUseCase
import com.example.crewmanagement.presentation.base.BaseViewModel
import com.example.crewmanagement.presentation.base.FailureResource
import com.example.crewmanagement.presentation.base.LoadingResource
import com.example.crewmanagement.presentation.base.ResultResource
import com.example.crewmanagement.presentation.base.SuccessResource
import com.example.crewmanagement.utils.SingleEvent
import kotlinx.coroutines.launch

class DetailActivityViewModel(
    private val getDetailUseCase: GetDetailUseCase
): BaseViewModel() {

    private val _getDetailLiveData = MutableLiveData<ResultResource<OompaLoompaDomain>>()
    val getDetailLiveData get() = _getDetailLiveData as LiveData<ResultResource<OompaLoompaDomain>>

    private val _oompaLoompaSelected = MutableLiveData<OompaLoompaDomain>()
    val oompaLoompaSelected get() = _oompaLoompaSelected as LiveData<OompaLoompaDomain>

    private val _showToastLiveData = MutableLiveData<SingleEvent<Any>>()
    val showToastLiveData get() = _showToastLiveData as LiveData<SingleEvent<Any>>

    fun initIntentData(oompaLoompa: OompaLoompaDomain) {
        _oompaLoompaSelected.value = oompaLoompa
    }

    fun getDetail(id: Int) {
        _getDetailLiveData.postValue(LoadingResource())
        viewModelScope.launch {
            kotlin.runCatching {
                getDetailUseCase.execute(id).let { _getDetailLiveData.postValue(SuccessResource(it))}
            }.onFailure {
                this@DetailActivityViewModel._getDetailLiveData.postValue(FailureResource(DEFAULT_ERROR))
            }
        }
    }

    fun showToastMessage(errorCode: Int) {
        val error = errorManager.getError(errorCode)
        _showToastLiveData.value = SingleEvent(error.description)
    }
}