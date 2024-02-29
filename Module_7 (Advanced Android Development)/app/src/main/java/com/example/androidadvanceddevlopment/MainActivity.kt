package com.example.androidadvanceddevlopment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidadvanceddevlopment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var questionList = mutableListOf<Question>()
    private lateinit var questionAdapter: QuestionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareData()

        questionAdapter = QuestionAdapter(this,questionList)
        binding.recyclerView.adapter = questionAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun prepareData() {
        questionList.add(Question(1,"1. set animation on splash screen with app logo"))
        questionList.add(Question(2,"2. Create an application to play song from raw resource folder "))
        questionList.add(Question(3,"3. Create an application to play song from mobile memory"))
        questionList.add(Question(4,"4. Create an application to play song from Server"))
        questionList.add(Question(5,"5. use WAKE LOCK when playing video play"))
        questionList.add(Question(6,"6. Create an application to convert text typed in edit text into speech "))
        questionList.add(Question(7,"7. Create an application for Wi-Fi on-off"))
    }
}