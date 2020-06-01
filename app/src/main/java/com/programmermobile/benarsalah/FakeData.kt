package com.programmermobile.benarsalah

object FakeData {
    fun getQuestions(): ArrayList<Question> {
        val questions = ArrayList<Question>()
        questions.add(Question("TWICE Tzuyu lahir di Tainan", R.drawable.tzuyu, true))
        questions.add(
            Question(
                "Alexander Graham Bell adalah penemu lampu pijar.",
                R.drawable.alexander_graham_bell,
                false
            )
        )
        questions.add(
            Question(
                "Orang yang terkena COVID-19 tidak bisa sembuh.",
                R.drawable.covid,
                false
            )
        )
        questions.add(Question("Ngoding itu susah.", R.drawable.coding, true))
        questions.add(
            Question(
                "Anak Agung Ayu Puspa Aditya Karang adalah member Girl Group K-Pop pertama dari Indonesia",
                R.drawable.secret_number,
                true
            )
        )
        return questions
    }
}