package com.ridwanproduction.learnandroidkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnNextJavaActivity: Button = findViewById(R.id.btnNextJava);
        btnNextJavaActivity.setOnClickListener {
            var intent: Intent = Intent(this, NextJavaActivity::class.java)
            startActivity(intent)
        }

        var btnNextKotlinActivity: Button = findViewById(R.id.btnNextKotlin);
        btnNextKotlinActivity.setOnClickListener {
            var intent: Intent = Intent(this, NextKotlinActivity::class.java)
            startActivity(intent)
        }
    }
}