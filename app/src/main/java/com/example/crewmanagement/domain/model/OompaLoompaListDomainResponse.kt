package com.example.crewmanagement.domain.model

import java.io.Serializable

data class OompaLoompaListDomainResponse(
    val current: Int?,
    val total: Int?,
    val results: List<OompaLoompaDomain>
) : Serializable