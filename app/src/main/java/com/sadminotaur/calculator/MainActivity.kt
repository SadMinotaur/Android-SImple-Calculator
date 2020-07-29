package com.sadminotaur.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.text)
    }

    @SuppressLint("SetTextI18n")
    fun buttonDigits(view: View) {
        val buttonText = (view as Button).text
        val startText = if (textView.text.toString() == "0") "" else textView.text.toString()
        textView.text = startText + buttonText
    }
}


