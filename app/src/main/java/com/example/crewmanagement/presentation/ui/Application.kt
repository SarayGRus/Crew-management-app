package com.example.crewmanagement.presentation.ui

import com.example.crewmanagement.data.di.generateDataModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import android.app.Application
import com.example.crewmanagement.presentation.di.generateApplicationModule
import org.kodein.di.android.x.androidXModule

class Application: Application(), KodeinAware {

    override val kodein: Kodein = Kodein {
        injectAppModule(this)?.let {
            import(it)
        }?: androidXModule(this@Application)
    }

     override fun onCreate() {
        super.onCreate()
    }

     fun injectAppModule(kodein: Kodein.MainBuilder): Kodein.Module {
        kodein.import(generateDataModule())
        return generateApplicationModule(this)
    }
}
