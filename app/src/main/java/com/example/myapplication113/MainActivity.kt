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
        setContentView(R.layout.activity_main)
        tvName = findViewById<View>(R.id.textView) as TextView
        btnName = findViewById<View>(R.id.button) as Button
        btnName!!.setOnClickListener(this)

        val saveButton = findViewById<Button>(R.id.button4)

        val firstName = findViewById<EditText>(R.id.editTextTextPersonName2)
        val lastName = findViewById<EditText>(R.id.editTextTextPersonName3)

        val secondIntent = Intent(this, NameActivity::class.java)

        val user = User(firstName.toString(), lastName.toString(), tvName.toString())

        val toast = Toast.makeText(applicationContext," Обнаружены пустые поля!", Toast.LENGTH_SHORT)

        saveButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

                if(user.firstName.equals(null)) toast.show()
                if(user.lastName.equals(null)) toast.show()
                if(user.workInfo.equals(null)) toast.show()

                user.lastName?.let {
                    user.firstName?.let {
                        user.workInfo?.let {
                            secondIntent.putExtra(USER, user)//стартовать, только если нигде не null
                            startActivity(secondIntent)
                        }
                    }
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
        tvName!!.text = "$name"
    }

}