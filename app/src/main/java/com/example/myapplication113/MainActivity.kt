package com.example.myapplication113

import android.content.Intent
import android.os.Bundle

import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

const val KEY_NAME = "KEY_NAME"
const val USER = "KEY_USER"

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var tvName: TextView? = null
    var btnName: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_l)

        tvName = findViewById<View>(R.id.workInfo) as TextView
        btnName = findViewById<View>(R.id.workInfoButton) as Button
        btnName!!.setOnClickListener(this)
        this.setTitle("UserActivityApp")

        val saveButton = findViewById<Button>(R.id.saveButton)

        val firstName = findViewById<EditText>(R.id.firstName)
        val lastName = findViewById<EditText>(R.id.lastName)

        val secondIntent = Intent(this, UserActivity::class.java)

        val user = User(firstName.text.toString(), lastName.text.toString(), tvName.toString())

        val toast =
            Toast.makeText(applicationContext, " Обнаружены пустые поля!", Toast.LENGTH_SHORT)

        saveButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

                if (user.firstName.equals(null) || user.lastName.equals(null) || user.workInfo.equals(null)) toast.show()

                if (user.firstName != null && user.lastName != null && user.workInfo != null) {
                    secondIntent.putExtra(USER, user)
                    startActivity(secondIntent)
                }
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
        requireNotNull(tvName).text ="$name"

    }

}