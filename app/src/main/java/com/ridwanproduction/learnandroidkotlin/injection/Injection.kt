package com.ridwanproduction.learnandroidkotlin.injection

import com.ridwanproduction.learnandroidkotlin.model.MuseumDataSource
import com.ridwanproduction.learnandroidkotlin.model.MuseumRepository
import com.ridwanproduction.learnandroidkotlin.viewmodel.ViewModelFactory

object Injection {
    private var museumDataSource: MuseumDataSource? = null
    private var museumRepository: MuseumRepository? = null
    private var museumViewModelFactory: ViewModelFactory? = null

    private fun createMuseumDataSource(): MuseumDataSource {
        val dataSource = MuseumRemoteDataSource(ApiClient)
        museumDataSource = dataSource
        return dataSource
    }

    private fun createMuseumRepository(): MuseumRepository {
        val repository = MuseumRepository(provideDataSource())
        museumRepository = repository
        return repository
    }

    private fun createFactory(): ViewModelFactory {
        val factory = ViewModelFactory(providerRepository())
        museumViewModelFactory = factory
        return factory
    }

}