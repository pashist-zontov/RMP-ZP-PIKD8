package ru.fefu.helloworld

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class ActivityPageMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page_main)
        val registerButton: Button = findViewById(R.id.registerButton)
        val loginText: TextView = findViewById(R.id.loginTextView)

        registerButton.setOnClickListener {
            val intent = Intent(this, ActivityPageReg::class.java)
            startActivity(intent)
        }

        loginText.setOnClickListener {
            val intent = Intent(this, ActivityPageLogin::class.java)
            startActivity(intent)
        }
    }
}