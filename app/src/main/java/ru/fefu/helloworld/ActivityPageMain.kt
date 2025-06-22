package ru.fefu.FEFUTrack

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import ru.fefu.helloworld.R

class ActivityPageMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_register)
        val backArr: Button = findViewById<R.id.imgBackarr>()

        backarr.setOnClickListener {
            val intent = Intent(this, ActivityPageMain::class.java)
            startActivity(intent)
        }

        val regButton: Button = findViewById(R.id.regButton)
    }

}