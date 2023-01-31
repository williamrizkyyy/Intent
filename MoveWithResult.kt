package com.example.myintentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup

class MoveWithResult : AppCompatActivity(), View.OnClickListener {
    private lateinit var radioGroup: RadioGroup
    private lateinit var btnpilih: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_result)
        radioGroup = findViewById(R.id.radiogrup)
        btnpilih = findViewById(R.id.pilihresult)
        btnpilih.setOnClickListener {
            val bundle = Bundle()
            val selectedID:Int = radioGroup.checkedRadioButtonId
            if (selectedID != -1){
                val radio: RadioButton = findViewById(selectedID)
                //println(radio.text.toString())

                bundle.putString("inputText", radio.text.toString())
                val intent = Intent(this,MainActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}