package com.ridwanproduction.learnandroidkotlin

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.app.NotificationCompat
import android.app.AlarmManager

import android.app.PendingIntent

import android.content.Intent
import android.util.Log
import com.ridwanproduction.learnandroidkotlin.utils.AlarmReceiver


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonNotif).setOnClickListener {
//            Log.d("RidwanStart", System.currentTimeMillis().toString())
            setAlarm()
        }
    }

    private fun setAlarm() {
        val intent = Intent(this, AlarmReceiver::class.java)
        intent.putExtra("NotificationText", "some text")
        val pendingIntent =
            PendingIntent.getBroadcast(this, 1234, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        val alarmManager = this.getSystemService(ALARM_SERVICE) as AlarmManager
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 1*60*1000, pendingIntent)
//        alarmManager[AlarmManager.RTC_WAKEUP, 70000] = pendingIntent
    }

    private fun showNotification() {
        val iconName = "ic_launcher"
        val typeDef = "mipmap"

        val smallIcon = applicationContext.resources.getIdentifier(
            iconName,
            typeDef,
            applicationContext.packageName
        )

        var notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        var builder: NotificationCompat.Builder
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Toast.makeText(applicationContext, "first", Toast.LENGTH_LONG).show()

            var notificationChannel: NotificationChannel
            notificationChannel =
                NotificationChannel("My_Id", "description", NotificationManager.IMPORTANCE_HIGH)
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.GREEN
            notificationChannel.enableVibration(false)
            notificationManager.createNotificationChannel(notificationChannel)

            builder = NotificationCompat.Builder(applicationContext, "My_Id")
                .setSmallIcon(smallIcon)
                .setContentTitle("textTitle")
                .setContentText("textContent")
                .setPriority(NotificationCompat.PRIORITY_MAX)
        } else {
            Toast.makeText(applicationContext, "second", Toast.LENGTH_LONG).show()

            builder = NotificationCompat.Builder(applicationContext, "My_Id")
                .setSmallIcon(smallIcon)
                .setContentTitle("textTitle")
                .setContentText("textContent")
                .setPriority(NotificationCompat.PRIORITY_MAX)
        }
        notificationManager.notify(1234, builder.build())

    }
}