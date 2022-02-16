package com.ridwanproduction.learnandroidkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnNextActivity: Button = findViewById(R.id.btnNextActivity);
        btnNextActivity.setOnClickListener {
            var intent: Intent = Intent(this, NextActivity::class.java)
            startActivity(intent)
        }
    }
}