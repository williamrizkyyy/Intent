package com.example.myintentapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var tvinputText : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button =
            findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveWithData:Button=
            findViewById(R.id.btn_move_with_data)
        btnMoveWithData.setOnClickListener(this)

        val btnMoveWithObject: Button=
            findViewById(R.id.btn_move_with_object)
        btnMoveWithObject.setOnClickListener(this)

        val btnDialNumber: Button=
            findViewById(R.id.btn_dial_number)
        btnDialNumber.setOnClickListener(this)

        val btnMoveWithResult: Button=
            findViewById(R.id.btn_move_with_result)
        btnMoveWithResult.setOnClickListener(this)

        tvinputText = findViewById(R.id.tv_input_text)

        if(intent.extras != null)
        {
            val bundle = intent.extras
            tvinputText.setText(bundle?.getString("inputText"))
        }else{
            tvinputText.setText(intent.getStringExtra("inputText"))
        }
    }

    override fun onClick(v: View){
        when(v.id){
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }

            R.id.btn_move_with_data ->{
                val MoveWithDataIntent = Intent(this@MainActivity, MoveWithData::class.java)
                MoveWithDataIntent.putExtra(MoveWithData.EXTRA_NAME,"William Rizky")
                MoveWithDataIntent.putExtra(MoveWithData.EXTRA_AGE,"16")
                startActivity(MoveWithDataIntent)
            }

            R.id.btn_move_with_object ->{
                val person = Person("William Rizky","williambahari57@gmail.com","Malang")
                val moveWithObject = Intent(this@MainActivity, MoveWithObject::class.java)
                moveWithObject.putExtra(MoveWithObject.EXTRA_PERSON,person)
                startActivity(moveWithObject)
            }

            R.id.btn_dial_number -> {
                val phoneNumber = "085704933409"
                val dialNumber = Intent(Intent.ACTION_DIAL, Uri.parse("tel: $phoneNumber"))
                startActivity(dialNumber)
            }

            R.id.btn_move_with_result ->{
                val moveWithResult = Intent(this@MainActivity, MoveWithResult::class.java)
                startActivity(moveWithResult)
            }
        }
    }

}