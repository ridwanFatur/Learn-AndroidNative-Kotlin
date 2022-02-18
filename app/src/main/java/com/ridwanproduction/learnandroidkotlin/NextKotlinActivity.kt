package com.ridwanproduction.learnandroidkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.ridwanproduction.learnandroidkotlin.model.ModelMVP

class NextKotlinActivity : AppCompatActivity(), FirstView  {
    lateinit var presenterImp: FirstPresenterImp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next_kotlin)

        presenterImp = FirstPresenterImp(this)
        var inputText = findViewById<EditText>(R.id.inputText)
        var buttonSubmit = findViewById<Button>(R.id.buttonSubmit)
        buttonSubmit.setOnClickListener {
            presenterImp.tambahData(inputText.text.toString())
        }
//        buttonSubmit.onClick {
//            presenterImp.tambahData(inputText.text.toString())
//        }
    }

    override fun berhasil(hasil: ModelMVP) {
//        alert {
//            title = hasil.textmsgg
//            noButton {
//            }
//            yesButton {d ->
//                d.dismiss()
//            }
//        }.show()
        Toast.makeText(this, "Berhasil", Toast.LENGTH_LONG).show()
    }

    override fun error() {
//        toast("tidak boleh kosong")
        Toast.makeText(this, "Tidak Boleh Kosong", Toast.LENGTH_LONG).show()
    }
}