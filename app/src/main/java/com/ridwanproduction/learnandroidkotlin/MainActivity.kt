package com.ridwanproduction.learnandroidkotlin

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.Handler
import android.widget.Button
import android.widget.Toast
import android.content.BroadcastReceiver
import android.content.Context

import androidx.localbroadcastmanager.content.LocalBroadcastManager

import android.content.IntentFilter
import android.app.AlarmManager

import android.app.PendingIntent











class MainActivity : AppCompatActivity() {
    var receiverForTest: MyTestReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupServiceReceiver()

        findViewById<Button>(R.id.buttonNotif).setOnClickListener {
            launchTestService()
        }
        scheduleAlarm()
    }

    fun scheduleAlarm() {
        // Construct an intent that will execute the AlarmReceiver
        val intent = Intent(applicationContext, MyAlarmReceiver::class.java)
        // Create a PendingIntent to be triggered when the alarm goes off
        val pIntent = PendingIntent.getBroadcast(
            this, MyAlarmReceiver.REQUEST_CODE,
            intent, PendingIntent.FLAG_UPDATE_CURRENT
        )
        // Setup periodic alarm every every half hour from this point onwards
        val firstMillis = System.currentTimeMillis() // alarm is set right away
        val alarm = this.getSystemService(ALARM_SERVICE) as AlarmManager
        // First parameter is the type: ELAPSED_REALTIME, ELAPSED_REALTIME_WAKEUP, RTC_WAKEUP
        // Interval can be INTERVAL_FIFTEEN_MINUTES, INTERVAL_HALF_HOUR, INTERVAL_HOUR, INTERVAL_DAY
        alarm.setInexactRepeating(
            AlarmManager.RTC_WAKEUP, firstMillis,
            AlarmManager.INTERVAL_HALF_HOUR, pIntent
        )
    }

    fun launchTestService() {
        // Construct our Intent specifying the Service
        val i = Intent(this, MyTestService::class.java)
        // Add extras to the bundle
        i.putExtra("foo", "bar")
        i.putExtra("receiver", receiverForTest)
        // Start the service
        startService(i)
    }

    fun setupServiceReceiver() {
        receiverForTest = MyTestReceiver(Handler())
        // This is where we specify what happens when data is received from the service
        receiverForTest!!.setReceiver { resultCode, resultData ->
            if (resultCode == RESULT_OK) {
                val resultValue = resultData.getString("resultValue")
                Toast.makeText(this@MainActivity, resultValue, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        // Register for the particular broadcast based on ACTION string
        val filter = IntentFilter(MyTestService.ACTION)
        LocalBroadcastManager.getInstance(this).registerReceiver(testReceiver, filter)
        // or `registerReceiver(testReceiver, filter)` for a normal broadcast
    }

    override fun onPause() {
        super.onPause()
        // Unregister the listener when the application is paused
        LocalBroadcastManager.getInstance(this).unregisterReceiver(testReceiver)
        // or `unregisterReceiver(testReceiver)` for a normal broadcast
    }

    // Define the callback for what to do when data is received
    private val testReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent) {
            val resultCode = intent.getIntExtra("resultCode", RESULT_CANCELED)
            if (resultCode == RESULT_OK) {
                val resultValue = intent.getStringExtra("resultValue")
                Toast.makeText(this@MainActivity, resultValue, Toast.LENGTH_SHORT).show()
            }
        }
    }
}