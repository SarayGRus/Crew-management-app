package com.example.crewmanagement.presentation.di

import android.app.Application
import android.content.res.Resources
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

fun generateApplicationModule(app: Application) = Kodein.Module(name = "AppModule") {
    bind<Application>() with singleton { app }


    bind<Resources>() with singleton { app.resources }

    /**
     * Managers
     */


    /**
     * Use case
     */
}
