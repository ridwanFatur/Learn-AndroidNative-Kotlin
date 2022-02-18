package com.ridwanproduction.learnandroidkotlin.View

interface ILoginView {
    fun OnLoginSuccess(message: String?)
    fun OnLoginError(message: String?)
}