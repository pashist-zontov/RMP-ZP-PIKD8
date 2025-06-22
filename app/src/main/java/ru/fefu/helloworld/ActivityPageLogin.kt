package ru.fefu.helloworld

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ActivityPageLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_login)
        val GoBack: Button = findViewById(R.id.imgBackarr)

        GoBack.setOnClickListener {
            val intent = Intent(this, ActivityPageMain::class.java)
            startActivity(intent)
        }

        val regButton: Button = findViewById(R.id.regButton)
    }
}