package com.example.crewmanagement.presentation.ui

import android.app.Application
import com.example.crewmanagement.data.di.generateDataModule
import com.example.crewmanagement.presentation.di.generateApplicationModule
import com.example.crewmanagement.presentation.di.injectionActivityModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@Application)
            modules(
                listOf(
                    injectionActivityModule,
                    generateApplicationModule,
                    generateDataModule
                )
            )
        }
    }
}
