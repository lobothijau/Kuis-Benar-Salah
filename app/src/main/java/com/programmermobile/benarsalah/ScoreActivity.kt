package com.programmermobile.benarsalah

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import kotlinx.android.synthetic.main.activity_score.*

class ScoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val scoreResult = intent.extras?.getInt("SCORE")
        score.text = scoreResult.toString()

        if (scoreResult != null) {
            if (scoreResult > 65) {
                score.setTextColor(Color.parseColor("#063708"))
            } else {
                score.setTextColor(Color.parseColor("#D61010"))
            }
        }

        play_again.setOnClickListener {
            val intent = Intent()
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}