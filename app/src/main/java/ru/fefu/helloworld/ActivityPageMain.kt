package ru.fefu.helloworld

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class ActivityPageMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page_main)
        val regButton: Button = findViewById(R.id.registerButton)
        val loginText: TextView = findViewById(R.id.loginTextView)

        regButton.setOnClickListener {
            val intent = Intent(this, ActivityPageRegister::class.java)
            startActivity(intent)
        }

        loginText.setOnClickListener {
            val intent = Intent(this, ActivityPageLogin::class.java)
            startActivity(intent)
        }
    }
}