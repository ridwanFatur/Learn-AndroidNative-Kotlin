package com.ridwanproduction.learnandroidkotlin.base

interface BasePresenter<in T : BaseView> {
    fun onAttach(view : T)
    fun onDettach()
}