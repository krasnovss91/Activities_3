package com.example.myapplication113


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class NameActivity : AppCompatActivity(), View.OnClickListener {
    var editText: EditText? = null
    var button: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)
        editText = findViewById<View>(R.id.editTextTextPersonName) as EditText
        button = findViewById<View>(R.id.button2) as Button
        button!!.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val intent = Intent()
        intent.putExtra(KEY_NAME, editText!!.text.toString())
        setResult(RESULT_OK, intent)
        finish()
    }
}