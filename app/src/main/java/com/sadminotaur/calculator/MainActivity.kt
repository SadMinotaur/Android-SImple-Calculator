package com.sadminotaur.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private val inMemory: HashMap<Char, Double> = HashMap()

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

    @SuppressLint("SetTextI18n")
    fun buttonDot(view: View) {
        val text = textView.text.toString()
        if (text != "" && !text.contains(".")) {
            textView.text = textView.text.toString() + "."
        }
    }

    @SuppressLint("SetTextI18n")
    fun clean(view: View) {
        textView.text = ""
    }

    @SuppressLint("SetTextI18n")
    fun actions(view: View) {
        val buttonText = (view as Button).text.toString()
        inMemory[buttonText[0]] = textView.text.toString().toDouble()
        textView.text = ""
    }
}