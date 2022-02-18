package com.ridwanproduction.learnandroidkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.ridwanproduction.learnandroidkotlin.model.HasilModel

class NextKotlinActivity : AppCompatActivity(),MainView {
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next_kotlin)

        presenter = MainPresenter(this)
        var submitHitung = findViewById<Button>(R.id.submitHitung)
        var input1 = findViewById<EditText>(R.id.input1)
        var input2 = findViewById<EditText>(R.id.input2)

        submitHitung.setOnClickListener {
            presenter.hitung(input1.text.toString(),input2.text.toString())
        }
    }

    override fun success(hasil: HasilModel) {
        var result = hasil.hasilmodel;
        Toast.makeText(this, result, Toast.LENGTH_LONG).show()
    }

    override fun error() {
        Toast.makeText(this, "Input Cannot be Empty", Toast.LENGTH_LONG).show()
    }

    override fun onAttachView() {
        presenter.onAttach(this)
    }

    override fun onDettachView() {
        onDettachView()
    }

    override fun onStart() {
        super.onStart()
        onAttachView()
    }

    override fun onDestroy() {
        super.onDestroy()
        onDettachView()
    }
}