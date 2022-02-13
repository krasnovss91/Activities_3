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
            //  val data = arguments?.get(USER).toString()//достали данные и разложить их по textView
        val data = intent.getParcelableExtra<User>(USER)
//http://developer.alexanderklimov.ru/android/theory/parcelable.php
        if (data != null) {
            firstName.text = data.firstName
        }
        if (data != null) {
            lastName.text = data.lastName
        }
        if (data != null) {
            workInfo.text = data.workInfo
        }

        /*
        	DocumentInfo documentInfo = (DocumentInfo)getIntent().getParcelableExtra("DocumentInfo");

	name = documentInfo.getCatName();
	whiskers = documentInfo.getWhiskers();
	paws = documentInfo.getPaws();
	tail = documentInfo.getTail();

	tvName.setText("Имя кота: " + name);
	tvWhiskers.setText("Усы: " + whiskers);
	tvPaws.setText("Лапы: " + paws);
	tvTail.setText("Хвост: " + tail);
         */

    }
}