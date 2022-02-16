package com.ridwanproduction.learnandroidkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonNotif).setOnClickListener {
            startService()
        }
    }

    fun startService(){
        val intent = Intent(this, MyService::class.java)
        startService(intent)
    }
}