package com.example.myapplication113

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class UserActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        this.setTitle("UserActivityApp")
        val firstName = findViewById<TextView>(R.id.firstName1)
        val lastName = findViewById<TextView>(R.id.lastName1)
        val workInfo = findViewById<TextView>(R.id.workInfo1)

        val data = intent.getParcelableExtra<User>(USER)

        firstName.text = data?.firstName
        lastName.text = data?.lastName
        workInfo.text = data?.workInfo

    }
}