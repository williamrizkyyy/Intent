package com.example.myintentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MoveWithData : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)

        val tvDataReceived : TextView = findViewById(R.id.tv_data_received)

        val name = intent.getStringExtra(EXTRA_NAME)
        val age = intent.getStringExtra(EXTRA_AGE)

        val text = "Name : $name, Your age : $age"
        tvDataReceived.text = text
    }
    companion object{
        const val EXTRA_NAME = "extra_age"
        const val EXTRA_AGE = "extra_name"
    }
}