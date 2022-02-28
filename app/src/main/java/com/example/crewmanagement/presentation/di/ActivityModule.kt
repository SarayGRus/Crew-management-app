package com.example.crewmanagement.presentation.di

import androidx.fragment.app.FragmentManager
import com.example.crewmanagement.presentation.base.BaseActivity
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.provider

fun injectionActivityModule(activity: BaseActivity) = Kodein.Module(name = "ActivityModule") {
    bind<FragmentManager>() with provider { activity.supportFragmentManager }

    //ViewModel

    //State


    //Navigator

    //Dialog

}
