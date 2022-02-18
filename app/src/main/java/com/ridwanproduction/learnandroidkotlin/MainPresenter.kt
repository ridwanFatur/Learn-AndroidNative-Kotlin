package com.ridwanproduction.learnandroidkotlin

import com.ridwanproduction.learnandroidkotlin.base.BasePresenter
import com.ridwanproduction.learnandroidkotlin.model.HasilModel

class MainPresenter : BasePresenter<MainView> {
    var modelview : MainView? = null

    constructor(model: MainView?) {
        this.modelview = model
    }

    fun hitung(satu : String,dua : String){
        if(satu.isNotEmpty() && dua.isNotEmpty()){
            val nilai1 = satu.toDouble()
            val nilai2 = dua.toDouble()
            val hasil = nilai1 * nilai2
            val model = HasilModel(hasil.toString())
            modelview?.success(model)
        }
        else{
            modelview?.error()
        }
    }

    override fun onAttach(view: MainView) {
        modelview = view
    }

    override fun onDettach() {
        modelview = null
    }
}