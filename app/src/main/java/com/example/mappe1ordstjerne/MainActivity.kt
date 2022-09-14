package com.example.mappe1ordstjerne

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btn1 : Button
    private lateinit var btn2 : Button
    private lateinit var btn3 : Button
    private lateinit var btn4 : Button
    private lateinit var btn5 : Button
    private lateinit var btn6 : Button
    private lateinit var btn7 : Button
    private lateinit var edUserInput : EditText
    private lateinit var btnCheck : Button
    private lateinit var btnHint : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initilizing Variables
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        edUserInput = findViewById(R.id.edUserInput)
        btnCheck = findViewById(R.id.btnHint)
        btnHint = findViewById(R.id.btnHint)

        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
        btn6.setOnClickListener(this)
        btn7.setOnClickListener(this)
    }


    //Setting each button
    override fun onClick(view: View?) {
        if (view != null) {
            when(view.id){
                R.id.btn1 -> {
                    val output : String = edUserInput.text.toString() + btn1.text.toString()
                    edUserInput.setText(output)
                }

                R.id.btn2 -> {
                    val output : String = edUserInput.text.toString() + btn2.text.toString()
                    edUserInput.setText(output)
                }
                R.id.btn3 -> {
                    val output : String = edUserInput.text.toString() + btn3.text.toString()
                    edUserInput.setText(output)
                }
                R.id.btn4 ->  {
                    val output : String = edUserInput.text.toString() + btn4.text.toString()
                    edUserInput.setText(output)
                }
                R.id.btn5 -> {
                    val output : String = edUserInput.text.toString() + btn5.text.toString()
                    edUserInput.setText(output)
                }
                R.id.btn6 -> {
                    val output : String = edUserInput.text.toString() + btn6.text.toString()
                    edUserInput.setText(output)
                }
                R.id.btn7 -> {
                    val output : String = edUserInput.text.toString() + btn7.text.toString()
                    edUserInput.setText(output)
                }

            }
        }
    }

}