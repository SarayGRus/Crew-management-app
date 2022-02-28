package com.example.crewmanagement.domain.repository

import com.example.crewmanagement.domain.model.OompaLoompaDomain
import com.example.crewmanagement.domain.model.OompaLoompaListDomainResponse

interface NetworkRepository {
    suspend fun getAll(): OompaLoompaListDomainResponse
    suspend fun getOompaLoompaDetail(id: Int): OompaLoompaDomain
}
