package com.example.mappe1ordstjerne

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.reflect.typeOf

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private lateinit var btn5: Button
    private lateinit var btn6: Button
    private lateinit var btn7: Button
    private lateinit var edUserInput: EditText
    private lateinit var tvAlertText: TextView
    private lateinit var btnCheck: Button
    private lateinit var btnHint: Button
    private lateinit var btnDelete: Button
    private lateinit var wordList: Array<String>
    private lateinit var userWordList: MutableList<String>

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
        btnCheck = findViewById(R.id.btnCheck)
        btnHint = findViewById(R.id.btnHint)
        btnDelete = findViewById(R.id.btnDelete)
        wordList = resources.getStringArray(R.array.wordList)
        tvAlertText = findViewById(R.id.tvAlertText)
        userWordList = mutableListOf()


        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
        btn6.setOnClickListener(this)
        btn7.setOnClickListener(this)
        btnCheck.setOnClickListener(this)
        btnHint.setOnClickListener(this)
        btnDelete.setOnClickListener(this)
    }


    //Setting each button´s onClickListener
    override fun onClick(view: View?) {
        if (view != null) {
            when (view.id) {
                R.id.btn1 -> {
                    val output: String = edUserInput.text.toString() + btn1.text.toString()
                    edUserInput.setText(output)
                }

                R.id.btn2 -> {
                    val output: String = edUserInput.text.toString() + btn2.text.toString()
                    edUserInput.setText(output)
                }
                R.id.btn3 -> {
                    val output: String = edUserInput.text.toString() + btn3.text.toString()
                    edUserInput.setText(output)
                }
                R.id.btn4 -> {
                    val output: String = edUserInput.text.toString() + btn4.text.toString()
                    edUserInput.setText(output)
                }
                R.id.btn5 -> {
                    val output: String = edUserInput.text.toString() + btn5.text.toString()
                    edUserInput.setText(output)
                }
                R.id.btn6 -> {
                    val output: String = edUserInput.text.toString() + btn6.text.toString()
                    edUserInput.setText(output)
                }
                R.id.btn7 -> {
                    val output: String = edUserInput.text.toString() + btn7.text.toString()
                    edUserInput.setText(output)
                    println("btn7 clicked")
                }

                R.id.btnCheck -> checkWord()


                R.id.btnHint -> {
                    giveHint()
                }

                R.id.btnDelete -> deleteText()

            }
        }
    }

    private fun giveHint() {
        TODO("Not yet implemented")
    }

    private fun checkWord() {


        var word = edUserInput.text.toString()
        word = word.lowercase().replace(" ", "")
        val keyLetter = resources.getString(R.string.btn7).lowercase()

        //for testing
        println("Inputord = ${word}")



        //Check for 4 letters
        if (word.length < 4) {
            tvAlertText.setText(resources.getText(R.string.tvAlert4Ord))
            return
        }

        //Check for duplicate inputs
        if (userWordList.contains(word)){
            tvAlertText.setText(resources.getText(R.string.tvAlertAllerdyUsed))
            return
        }


        //Checks key-letter and the answers array
        if (word.contains(keyLetter)) {
            if (wordList.contains(word)) {
                addCorrectWord()
            } else {
                tvAlertText.setText(resources.getText(R.string.tvAlertWrongWord))
                return
            }
        } else {
            tvAlertText.setText(resources.getText(R.string.tvAlertKeyLetter))
        }

    }

    private fun addCorrectWord() {
        //Koden er duplisert, spørr Sanna..
        var word = edUserInput.text.toString()
        word = word.lowercase().replace(" ", "")

        deleteText()
        userWordList.add(word)


    }

    private fun deleteText() {
        edUserInput.setText("")
        tvAlertText.setText("")
    }

}