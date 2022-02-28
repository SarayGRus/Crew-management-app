package com.example.crewmanagement.data.di

import com.example.crewmanagement.domain.repository.NetworkRepository
import org.koin.dsl.module

val generateDataModule = module {
    single<NetworkRepository>() { com.example.crewmanagement.data.repository.NetworkRepository()}
}