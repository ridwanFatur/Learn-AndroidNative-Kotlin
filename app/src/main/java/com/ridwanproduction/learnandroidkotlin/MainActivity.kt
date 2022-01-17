package com.ridwanproduction.learnandroidkotlin

import android.Manifest
import android.R.attr
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.view.View
import android.widget.Button
import android.R.attr.data

import android.graphics.Bitmap

import android.app.Activity
import android.R.attr.data
import android.R.attr.data
import android.widget.Toast

import android.content.pm.PackageManager
import android.os.Build
import android.provider.MediaStore


class MainActivity : AppCompatActivity() {
    private val CAMERA_REQUEST = 1888
    private lateinit var imageView: ImageView
    private val MY_CAMERA_PERMISSION_CODE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById<ImageView>(R.id.imageView1)
        findViewById<Button>(R.id.button1).setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(arrayOf(Manifest.permission.CAMERA), MY_CAMERA_PERMISSION_CODE)
                } else {
                    val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    startActivityForResult(cameraIntent, CAMERA_REQUEST)
                }
            }

        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults[0] === PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "camera permission granted", Toast.LENGTH_LONG).show()
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraIntent, CAMERA_REQUEST)
        } else {
            Toast.makeText(this, "camera permission denied", Toast.LENGTH_LONG).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode === CAMERA_REQUEST && resultCode === RESULT_OK) {
            var photo: Bitmap = data?.extras?.get("data") as Bitmap
            imageView.setImageBitmap(photo)
        }
    }
}