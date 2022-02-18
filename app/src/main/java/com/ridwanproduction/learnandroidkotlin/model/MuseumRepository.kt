package com.ridwanproduction.learnandroidkotlin.model

import com.ridwanproduction.learnandroidkotlin.data.OperationCallback

class MuseumRepository(private val museumDataSource: MuseumDataSource) {
    fun fetchMuseums(callback: OperationCallback<Museum>) {
        museumDataSource.retrieveMuseums(callback)
    }

    fun cancel() {
        museumDataSource.cancel()
    }
}