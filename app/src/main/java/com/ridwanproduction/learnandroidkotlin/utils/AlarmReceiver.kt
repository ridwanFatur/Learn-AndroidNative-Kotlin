package com.ridwanproduction.learnandroidkotlin.utils
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.content.BroadcastReceiver
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat.getSystemService


class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        // create notification here
        showNotification(context)
//        Log.d("RidwanEnd", System.currentTimeMillis().toString())
    }

    private fun showNotification(context: Context?) {
        val iconName = "ic_launcher"
        val typeDef = "mipmap"

        val smallIcon = context!!.resources.getIdentifier(
            iconName,
            typeDef,
            context.packageName
        )

//        var notificationManager =
//            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        var notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        var builder: NotificationCompat.Builder
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            Toast.makeText(context, "first", Toast.LENGTH_LONG).show()

            var notificationChannel: NotificationChannel
            notificationChannel =
                NotificationChannel("My_Id", "description", NotificationManager.IMPORTANCE_HIGH)
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.GREEN
            notificationChannel.enableVibration(false)
            notificationManager.createNotificationChannel(notificationChannel)

            builder = NotificationCompat.Builder(context, "My_Id")
                .setSmallIcon(smallIcon)
                .setContentTitle("textTitle")
                .setContentText("textContent")
                .setPriority(NotificationCompat.PRIORITY_MAX)
        } else {
//            Toast.makeText(context, "second", Toast.LENGTH_LONG).show()

            builder = NotificationCompat.Builder(context, "My_Id")
                .setSmallIcon(smallIcon)
                .setContentTitle("textTitle")
                .setContentText("textContent")
                .setPriority(NotificationCompat.PRIORITY_MAX)
        }
        notificationManager.notify(1234, builder.build())

    }
}