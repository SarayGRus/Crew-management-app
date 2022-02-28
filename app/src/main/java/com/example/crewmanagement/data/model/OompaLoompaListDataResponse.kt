package com.example.crewmanagement.data.model

import com.example.crewmanagement.domain.model.OompaLoompaListDomainResponse
import com.example.crewmanagement.utils.checknull
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class OompaLoompaListDataResponse(
    @SerializedName("current")
    private val current: Int?,
    @SerializedName("total")
    private val total: Int?,
    @SerializedName("results")
    private val results: List<OompaLoompaData>
) : Serializable {
    fun toDomainModel(): OompaLoompaListDomainResponse =
        OompaLoompaListDomainResponse(
            current = current?.checknull(),
            total = total?.checknull(),
            results = results.map { item -> item.toDomainModel()}
        )
}