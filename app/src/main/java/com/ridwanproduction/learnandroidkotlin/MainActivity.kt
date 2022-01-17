package com.ridwanproduction.learnandroidkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnNextDrawing: Button = findViewById(R.id.btnNextDrawing);
        btnNextDrawing.setOnClickListener {
            var intent: Intent = Intent(this, DrawingActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnCustomDrawing).setOnClickListener {

        }
    }
}