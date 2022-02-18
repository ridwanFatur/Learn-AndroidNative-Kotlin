package com.ridwanproduction.learnandroidkotlin

import com.ridwanproduction.learnandroidkotlin.base.BaseView
import com.ridwanproduction.learnandroidkotlin.model.HasilModel

interface MainView : BaseView {
    fun success(hasil : HasilModel)
    fun error()
}