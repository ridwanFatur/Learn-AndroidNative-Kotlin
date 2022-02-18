package com.ridwanproduction.learnandroidkotlin

import com.ridwanproduction.learnandroidkotlin.model.ModelMVP

interface FirstView {
    fun berhasil(hasil : ModelMVP)
    fun error()
}