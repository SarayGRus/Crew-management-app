package com.apba.pasajero.data.di

import com.apba.pasajero.domain.repository.LocalRepository
import com.apba.pasajero.domain.repository.NetworkRepository
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

val generateDataModule = module {
    single<NetworkRepository> { NetworkRepository()}
}
