package ru.fefu.helloworld

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class T2ActivityRegistration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_register)
        val backArr: Button = findViewById(R.id.imgBackarr)

        backArr.setOnClickListener {
            val intent = Intent(this, ActivityPageMain::class.java)
            startActivity(intent)
        }
    }
}