package com.example.midtermquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var etStr: EditText
    private lateinit var btnGetAnswers: Button
    private lateinit var etQuestion1: EditText
    private lateinit var etQuestion2: EditText
    private lateinit var etQuestion3: EditText

    private val vowels = "aeiou"
    private val consonants = "bcdfghjklmnpqrstvwxyz"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etStr = findViewById(R.id.etStr)
        btnGetAnswers = findViewById(R.id.btnGetAnswers)
        etQuestion1 = findViewById(R.id.etQuestion1)
        etQuestion2 = findViewById(R.id.etQuestion2)
        etQuestion3 = findViewById(R.id.etQuestion3)

        btnGetAnswers.setOnClickListener {
            etQuestion1.setText(etStr.text.toString().convertConsonantsToSign())
            // 2.2 convert the string to uppercase
            etQuestion2.setText(etStr.text.toString().uppercase())
            etQuestion3.setText(etStr.text.toString().getVowelCount().toString())
        }
    }

    // 2.1 convert all consonant to $
    private fun String.convertConsonantsToSign(replacement: Char = '$'): String {
        var processedStr = ""
        for (char in this) {
            processedStr += if (char.lowercase() in consonants) replacement else char
        }
        return processedStr
    }

    // 2.3 total number of vowels
    private fun String.getVowelCount(): Int {
        var i = 0
        for (char in this) { if (char in vowels) i++ }
        return i
    }
}