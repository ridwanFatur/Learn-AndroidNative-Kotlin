package com.ridwanproduction.learnandroidkotlin.data

interface OperationCallback<T> {
    fun onSuccess(data: List<T>?)
    fun onError(error: String?)
}