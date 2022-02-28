package com.example.crewmanagement.data.repository

import com.example.crewmanagement.Environment
import com.example.crewmanagement.data.net.CrewManagementApi
import com.example.crewmanagement.data.net.Retrofit
import com.example.crewmanagement.domain.repository.NetworkRepository
import okhttp3.logging.HttpLoggingInterceptor
import com.example.crewmanagement.BuildConfig
import com.example.crewmanagement.domain.model.OompaLoompaDomain
import com.example.crewmanagement.domain.model.OompaLoompaListDomainResponse


class NetworkRepository(
) : NetworkRepository {

    private lateinit var crewManagementApi: CrewManagementApi

    /**
     * Retrofit initialization
     */

    private var retrofit: retrofit2.Retrofit = createRetrofit()
        set(value) {
            field = value
            crewManagementApi = field.create(CrewManagementApi::class.java)
        }

    init {
        retrofit = createRetrofit()
    }

    private fun createRetrofit(): retrofit2.Retrofit =
        Retrofit.Builder()
            .baseUrl(Environment.CrewManagementApi.BASE_URL)
            .ignoreSSL(Environment.CrewManagementApi.IGNORE_SSL)
            .httpLoggingInterceptorLevel(
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                else HttpLoggingInterceptor.Level.NONE
            )
            .build()

    /**
     * Repository function
     */

    override suspend fun getAll(): OompaLoompaListDomainResponse =
        crewManagementApi.getAll().toDomainModel()

    override suspend fun getOompaLoompaDetail(id: Int): OompaLoompaDomain =
        crewManagementApi.getOompaLoompaDetail(id).toDomainModel()

}
