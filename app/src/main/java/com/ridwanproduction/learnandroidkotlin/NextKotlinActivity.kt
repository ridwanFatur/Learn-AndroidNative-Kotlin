package com.ridwanproduction.learnandroidkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class NextKotlinActivity : AppCompatActivity() {
    var binding: ActivityLoginBinding? = null
    var viewmodel: LoginViewModel? = null
    var customeProgressDialog: CustomeProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_next_kotlin)
    }
}