package com.ridwanproduction.learnandroidkotlin

import com.ridwanproduction.learnandroidkotlin.model.ModelMVP

class FirstPresenterImp (model : FirstView) : FirstPresenter{
    var viewmodel : FirstView? = null
    init {
        viewmodel = model
    }

    override fun tambahData(msg: String) {
        if(msg.isNotEmpty()){
            var model = ModelMVP(msg)
            viewmodel?.berhasil(model)
        }else{
            viewmodel?.error()
        }
    }
}