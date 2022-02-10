package com.example.myapplication113

import android.content.Intent
import android.os.Bundle

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

const val KEY_NAME = "KEY_NAME"

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var tvName: TextView? = null
    var btnName: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvName = findViewById<View>(R.id.textView) as TextView
        btnName = findViewById<View>(R.id.button) as Button
        btnName!!.setOnClickListener(this)

        val saveButton = findViewById<Button>(R.id.button4)

        saveButton.setOnClickListener(object : View.OnClickListener {//собрать экземпляр класса-наследника Parcelable и сохранить его здесь
            override fun onClick(v: View?) {

            }
        })
    }

    override fun onClick(v: View) {
        val intent = Intent(this, NameActivity::class.java)
        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data == null) {
            return
        }
        val name = data.getStringExtra(KEY_NAME)
        tvName!!.text = "$name"
    }

}