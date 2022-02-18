package com.ridwanproduction.learnandroidkotlin.model

import com.ridwanproduction.learnandroidkotlin.data.OperationCallback

interface MuseumDataSource {
    fun retrieveMuseums(callback: OperationCallback<Museum>)
    fun cancel()
}