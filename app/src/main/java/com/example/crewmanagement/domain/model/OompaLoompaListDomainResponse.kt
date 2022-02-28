package com.example.crewmanagement.domain.model

import com.google.gson.annotations.SerializedName

data class OompaLoompaListDomainResponse(
    private val current: Int?,
    private val total: Int?,
    private val results: List<OompaLoompaDomain>
) {
}