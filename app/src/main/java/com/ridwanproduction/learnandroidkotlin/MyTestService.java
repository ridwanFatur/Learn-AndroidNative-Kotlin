package com.ridwanproduction.learnandroidkotlin;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class MyTestService extends IntentService {
    public static final String ACTION = "com.ridwanproduction.learnandroidkotlin.MyTestService";

    // Must create a default constructor
    public MyTestService() {
        // Used to name the worker thread, important only for debugging.
        super("test-service");
    }

    @Override
    public void onCreate() {
        super.onCreate(); // if you override onCreate(), make sure to call super().
        // If a Context object is needed, call getApplicationContext() here.
    }

    @Override
    protected void onHandleIntent(Intent intent) {
//        // This describes what will happen when service is triggered
//        ResultReceiver rec = intent.getParcelableExtra("receiver");
//        // Extract additional values from the bundle
//        String val = intent.getStringExtra("foo");
//        // To send a message to the Activity, create a pass a Bundle
//        Bundle bundle = new Bundle();
//        bundle.putString("resultValue", "My Result Value. Passed in: " + val);
//        // Here we call send passing a resultCode and the bundle of extras
//        rec.send(Activity.RESULT_OK, bundle);
        // Fetch data passed into the intent on start
        String val = intent.getStringExtra("foo");
        // Construct an Intent tying it to the ACTION (arbitrary event namespace)
        Intent in = new Intent(ACTION);
        // Put extras into the intent as usual
        in.putExtra("resultCode", Activity.RESULT_OK);
        in.putExtra("resultValue", "My Result Value. Passed in: " + val);
        // Fire the broadcast with intent packaged
        LocalBroadcastManager.getInstance(this).sendBroadcast(in);
        // or sendBroadcast(in) for a normal broadcast;
    }
}
