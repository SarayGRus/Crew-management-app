package com.example.crewmanagement.domain.usecase

import com.example.crewmanagement.domain.model.OompaLoompaDomain
import com.example.crewmanagement.domain.model.OompaLoompaListDomainResponse
import com.example.crewmanagement.domain.repository.NetworkRepository

class GetDetailUseCase(
    private val repository: NetworkRepository
) : BaseUseCase<Int, OompaLoompaDomain>() {

    override suspend fun useCaseFunction(id: Int): OompaLoompaDomain {
        return repository.getOompaLoompaDetail(id)
    }
}