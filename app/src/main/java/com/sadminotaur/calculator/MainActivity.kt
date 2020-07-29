package com.sadminotaur.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.tan

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
        inMemory.clear();
        val buttonText = (view as Button).text.toString()
        inMemory[buttonText[0]] = textView.text.toString().toDouble()
        textView.text = ""
    }

    @SuppressLint("SetTextI18n")
    fun getResult(view: View) {
        if (inMemory.size == 1) {
            val action = inMemory.keys.firstOrNull()
            val memoryNum = inMemory[action]
            when (action) {
                '/' -> {
                    textView.text = (memoryNum!! / textView.text.toString().toDouble()).toString()
                        .removeSuffix(".0")
                }
                '-' -> {
                    textView.text = (memoryNum!! - textView.text.toString().toDouble()).toString()
                        .removeSuffix(".0")
                }
                '+' -> {
                    textView.text = (memoryNum!! + textView.text.toString().toDouble()).toString()
                        .removeSuffix(".0")
                }
                '*' -> {
                    textView.text = (memoryNum!! * textView.text.toString().toDouble()).toString()
                        .removeSuffix(".0")
                }
            }
        }
    }

    fun trigResult(view: View) {
        when ((view as Button).text.toString()) {
            "cos" -> {
                textView.text = cos(textView.text.toString().toDouble()).toString()
            }
            "sin" -> {
                textView.text = sin(textView.text.toString().toDouble()).toString()
            }
            "tan" -> {
                textView.text = tan(textView.text.toString().toDouble()).toString()
            }
        }
    }
}