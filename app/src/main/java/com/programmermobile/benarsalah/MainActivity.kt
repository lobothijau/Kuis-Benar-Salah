package com.programmermobile.benarsalah

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var questionIndex = 0
    val questions = FakeData.getQuestions()
    val answers = ArrayList<Boolean>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progress_bar.max = questions.size

        loadQuestion(questionIndex)

        benar.setOnClickListener(this)
        salah.setOnClickListener(this)
    }

    private fun loadQuestion(questionIndex: Int) {
        question_number.text = "${(questionIndex + 1)}."
        question.text = questions[questionIndex].question
        imageView.setImageDrawable(getDrawable(questions[questionIndex].image))
        progress_bar.progress = questionIndex + 1
        progress_text.text = "${questionIndex + 1}/${questions.size}"
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.benar) {
            answers.add(questionIndex, true)
        }
        if (v?.id == R.id.salah) {
            answers.add(questionIndex, false)
        }
        questionIndex += 1
        if (questionIndex < questions.size) {
            loadQuestion(questionIndex)
        } else {
            var score = 0
            for (i in 0 until questions.size) {
                if (answers[i] == questions[i].isTrue) score += 20
            }
            val intent = Intent(this, ScoreActivity::class.java)
            intent.putExtra("SCORE", score)
            startActivityForResult(intent, 212)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 212) {
            if (resultCode == Activity.RESULT_OK) {
                questionIndex = 0
                loadQuestion(questionIndex)
            } else {
                Toast.makeText(this, "Bosan ya?", Toast.LENGTH_SHORT).show()
            }
        }
    }
}