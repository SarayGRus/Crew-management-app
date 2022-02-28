package com.example.crewmanagement.domain.usecase

import com.example.crewmanagement.domain.model.OompaLoompaListDomainResponse
import com.example.crewmanagement.domain.repository.NetworkRepository

class GetAllUseCase(
    private val repository: NetworkRepository
) : BaseUseCase<Unit, OompaLoompaListDomainResponse>() {

    override suspend fun useCaseFunction(input: Unit): OompaLoompaListDomainResponse {
        return repository.getAll()
    }
}