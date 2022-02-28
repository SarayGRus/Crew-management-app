package com.example.crewmanagement.data.net

import com.example.crewmanagement.data.model.OompaLoompaData
import com.example.crewmanagement.data.model.OompaLoompaListDataResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CrewManagementApi {
    @GET("oompa-loompas")
    suspend fun getAll(): OompaLoompaListDataResponse

    @GET("oompa-loompas/")
    suspend fun getOompaLoompaDetail(@Path("id") id: Int): OompaLoompaData
}
