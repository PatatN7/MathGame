package com.exampletests.mathgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var buttonAdd : Button
    lateinit var buttonSub : Button
    lateinit var buttonMulti : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonAdd = findViewById(R.id.buttonAdd)
        buttonSub = findViewById(R.id.buttonSub)
        buttonMulti = findViewById(R.id.buttonMulti)

        buttonAdd.setOnClickListener {

            var intent = Intent(this@MainActivity, GameActivity::class.java)
            startActivity(intent)

        }

    }
}