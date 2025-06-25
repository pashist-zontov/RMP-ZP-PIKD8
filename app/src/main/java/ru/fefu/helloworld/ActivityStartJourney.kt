package ru.fefu.helloworld

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ActivityStartJourney: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_journey_start)

        supportFragmentManager.beginTransaction()
            .replace(R.id.activChooser, ChoiceFragment.newInstance())
            .commit()
    }
}