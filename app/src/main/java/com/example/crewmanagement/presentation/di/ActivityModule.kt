package com.example.crewmanagement.presentation.di

import com.example.crewmanagement.presentation.ui.main.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val injectionActivityModule = module {
    viewModel { MainActivityViewModel(get()) }
}

