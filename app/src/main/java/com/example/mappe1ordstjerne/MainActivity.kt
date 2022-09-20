package com.example.mappe1ordstjerne
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.ArrayList

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
    private lateinit var userWordList: java.util.ArrayList<String>
    private lateinit var tvCorrectAnswers: TextView
    private lateinit var btnAnswers: Button
    private lateinit var tvCount : TextView

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
        userWordList = ArrayList()
        tvCorrectAnswers = findViewById(R.id.tvCorrectAnswers)
        btnAnswers = findViewById(R.id.btnAnswers)
        tvCount = findViewById(R.id.tvCount)


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
        btnAnswers.setOnClickListener(this)

        updateCount()



    }
    override fun onSaveInstanceState(outState: Bundle) { // Here You have to save count value
        super.onSaveInstanceState(outState)

        outState.putString("count", tvCount.text.toString())
        outState.putStringArrayList(
            "wordlist",
            userWordList
        )
        outState.putString("errorMessage", tvAlertText.text.toString())

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) { // Here You have to restore count value
        super.onRestoreInstanceState(savedInstanceState)

        tvCount.text = savedInstanceState.getString("count")
        userWordList = savedInstanceState.getStringArrayList("wordlist") as ArrayList<String>
        tvCorrectAnswers.text = capitalize(userWordList.toString().replace("[", "").replace("]", ""))
        tvAlertText.text = savedInstanceState.getString("errorMessage")

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


                R.id.btnHint -> giveHint()

                R.id.btnDelete -> deleteText()

                R.id.btnAnswers -> giveAnswers()

            }
        }
    }

    //Formats the array
    private fun giveAnswers() {
        userWordList = wordList.toCollection(ArrayList())
        tvCorrectAnswers.text =
            capitalize(userWordList.toString().replace("[", "").replace("]", ""))
    }

    private fun giveHint() {

        //Finner et tilfedlig ord i ordlisten
        val arr = wordList.toList()
        val randomIndex = kotlin.random.Random.nextInt(arr.size)
        val randomWord = arr[randomIndex]

        //Finner en tifeldig bokstav i ordet
        val randomLetterIndex = kotlin.random.Random.nextInt(randomWord.count())
        val randomLetter = randomWord[randomLetterIndex]


        val arr1 = randomWord.toCharArray()
        arr1.forEachIndexed { index, _ ->
            if (arr1[index] != randomLetter){
                arr1[index] = '*'

            }
        }

        tvAlertText.text = String(arr1).uppercase()

    }

    private fun checkWord() {


        val word = getWord()
        val keyLetter = resources.getString(R.string.btn7).lowercase()



        //Check for 4 letters
        if (word.length < 4) {
            tvAlertText.text = resources.getText(R.string.tvAlert4Ord)
            return
        }

        //Check for duplicate inputs
        if (userWordList.contains(word)) {
            tvAlertText.text = resources.getText(R.string.tvAlertAlreadyUsed)
            return
        }


        //Checks key-letter and the answers array
        if (word.contains(keyLetter)) {
            if (wordList.contains(word)) {
                addCorrectWord()
            } else {
                tvAlertText.text = resources.getText(R.string.tvAlertWrongWord)
                return
            }
        } else {
            tvAlertText.text = resources.getText(R.string.tvAlertKeyLetter)
        }

    }


    private fun addCorrectWord() {

        val word = getWord()
        deleteText()
        userWordList.add(word)
        userWordList.sort()
        tvCorrectAnswers.setText(
            capitalize(
                userWordList.toString().replace("[", "").replace("]", "")
            )
        )

        updateCount()
    }

    private fun updateCount() {
       val total = wordList.count()
       val userWords = userWordList.count()
        tvCount.text = "${userWords}/${total}"
    }

    private fun deleteText() {
        edUserInput.setText("")
        tvAlertText.text = ""

    }

    //Capitilzes first letter of a word in a string
    private fun capitalize(str: String): String {
        return str.trim().split("\\s+".toRegex())
            .map { it.capitalize() }.joinToString(" ")
    }

    //Get Input Word
    private fun getWord(): String {
        var word = edUserInput.text.toString()
        word = word.lowercase().replace(" ", "")
        return word
    }
}
