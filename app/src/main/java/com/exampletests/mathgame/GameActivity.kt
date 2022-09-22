package com.exampletests.mathgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class GameActivity : AppCompatActivity() {

    lateinit var textScore : TextView
    lateinit var textLife : TextView
    lateinit var textTime : TextView

    lateinit var textQuestion : TextView
    lateinit var textAnswer : EditText

    lateinit var buttonOk : Button
    lateinit var buttonNext : Button

    var correctAnswer = 0
    var score = 0
    var life = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        textScore = findViewById(R.id.textViewScore)
        textLife = findViewById(R.id.textViewLife)
        textTime = findViewById(R.id.textViewTime)

        textQuestion = findViewById(R.id.textViewQuestion)
        textAnswer = findViewById(R.id.editTextNumber)

        buttonOk = findViewById(R.id.buttonOk)
        buttonNext = findViewById(R.id.buttonNext)

        gameContinue()

        buttonOk.setOnClickListener {

            val answer = textAnswer.text.toString()

            if(answer == ""){
                Toast.makeText(applicationContext, "Please enter an answer.", Toast.LENGTH_LONG).show()
            }
            else{
                if(correctAnswer == answer.toInt()){
                    textQuestion.setText("Congratulations, the answer is correct")
                    score += 10
                    textScore.text = score.toString()
                }
                else{
                    textQuestion.setText("Sorry, the answer is incorrect")
                    life--
                    textLife.text = life.toString()
                }
            }
        }

        buttonNext.setOnClickListener {
            gameContinue()
            textAnswer.setText("")
        }

    }

    fun gameContinue(){
        val number1 = Random.nextInt(0,100)
        val number2 = Random.nextInt(0,100)

        textQuestion.setText("$number1 + $number2")

        correctAnswer = number1 + number2

    }
}