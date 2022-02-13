package com.example.myapplication113

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class UserActivity : AppCompatActivity() {

    val firstName = findViewById<TextView>(R.id.firstName1)
    val lastName = findViewById<TextView>(R.id.lastName1)
    val workInfo = findViewById<TextView>(R.id.workInfo1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val arguments = intent.extras
        val data = arguments?.get(USER).toString()//достали данные и разложить их по textView
//http://developer.alexanderklimov.ru/android/theory/parcelable.php
      //  firstName.text =
      //  lastName.text =
      //  workInfo.text =

    }
}