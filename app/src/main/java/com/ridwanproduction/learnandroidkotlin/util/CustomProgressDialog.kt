package com.ridwanproduction.learnandroidkotlin.util

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.ImageView
import com.ridwanproduction.learnandroidkotlin.R

class CustomProgressDialog(context: Context?) : Dialog(context!!)  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_progress)
        setCancelable(false)
        setCanceledOnTouchOutside(false)
        val rotate = RotateAnimation(
            0f, 360f,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        )
        rotate.duration = 1000
        rotate.repeatCount = Animation.INFINITE
        var iv_logo: ImageView = findViewById(R.id.iv_logo)
        iv_logo.startAnimation(rotate)
    }
}