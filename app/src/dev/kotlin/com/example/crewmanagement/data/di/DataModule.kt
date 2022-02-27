package com.example.crewmanagement.data.di

import com.example.crewmanagement.domain.repository.NetworkRepository
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

fun generateDataModule() = Kodein.Module(name = "DataModule") {

    bind<NetworkRepository>() with singleton {
        com.example.crewmanagement.data.repository.NetworkRepository(
        )
    }
}
