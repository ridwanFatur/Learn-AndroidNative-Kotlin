package com.ridwanproduction.learnandroidkotlin

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btnRequest).setOnClickListener {
            simpleRequest().execute();
        };
    }

    inner class simpleRequest() : AsyncTask<String, Void, String>() {
        override fun onPreExecute() {
            super.onPreExecute()
            findViewById<ProgressBar>(R.id.loader).visibility = View.VISIBLE
            findViewById<TextView>(R.id.errorText).visibility = View.GONE
            findViewById<TextView>(R.id.errorText).text = ""
            findViewById<TextView>(R.id.dataText).visibility = View.GONE
            findViewById<TextView>(R.id.dataText).text = ""
        }

        override fun doInBackground(vararg params: String?): String? {
            var response: String?
            try {
                response =
                    URL("https://jsonplaceholder.typicode.com/todos/1").readText(
                        Charsets.UTF_8
                    )
            } catch (e: Exception) {
                response = null
            }
            return response
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            if (result != null){
                findViewById<ProgressBar>(R.id.loader).visibility = View.GONE
                findViewById<TextView>(R.id.dataText).visibility = View.VISIBLE
                findViewById<TextView>(R.id.dataText).text = result
            }else{
                findViewById<ProgressBar>(R.id.loader).visibility = View.GONE
                findViewById<TextView>(R.id.errorText).visibility = View.VISIBLE
                findViewById<TextView>(R.id.errorText).text = "Error"
            }
        }
    }
}