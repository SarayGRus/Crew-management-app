package com.example.crewmanagement.presentation.di

import com.example.crewmanagement.domain.usecase.GetAllUseCase
import org.koin.dsl.module

val generateApplicationModule = module {
    single { GetAllUseCase(get()) }
}

