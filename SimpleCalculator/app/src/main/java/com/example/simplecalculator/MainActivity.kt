package com.example.simplecalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var num1: EditText
    private lateinit var num2: EditText
    private lateinit var resultView: TextView
    private lateinit var add: Button
    private lateinit var sub: Button
    private lateinit var mul: Button
    private lateinit var div: Button
    private lateinit var mod: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Bind views from XML
        num1 = findViewById(R.id.editTextText)
        num2 = findViewById(R.id.editTextText2)
        resultView = findViewById(R.id.resultView)

        add = findViewById(R.id.button)
        sub = findViewById(R.id.button2)
        mul = findViewById(R.id.button3)
        div = findViewById(R.id.button4)
        mod = findViewById(R.id.button5)

        // Common click listener
        add.setOnClickListener { performOperation("+") }
        sub.setOnClickListener { performOperation("-") }
        mul.setOnClickListener { performOperation("*") }
        div.setOnClickListener { performOperation("/") }
        mod.setOnClickListener { performOperation("%") }
    }

    private fun performOperation(op: String) {
        val n1Text = num1.text.toString()
        val n2Text = num2.text.toString()

        if (n1Text.isEmpty() || n2Text.isEmpty()) {
            resultView.text = "Please enter both numbers"
            return
        }

        val n1 = n1Text.toDouble()
        val n2 = n2Text.toDouble()

        val result = when (op) {
            "+" -> n1 + n2
            "-" -> n1 - n2
            "*" -> n1 * n2
            "/" -> if (n2 != 0.0) n1 / n2 else "Cannot divide by zero"
            "%" -> if (n2 != 0.0) n1 % n2 else "Cannot modulo by zero"
            else -> "Invalid Operation"
        }

        resultView.text = "$result"
    }
}
