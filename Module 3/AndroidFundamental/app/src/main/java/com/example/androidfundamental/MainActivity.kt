package com.example.androidfundamental

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidfundamental.adapter.QuestionListAdapter
import com.example.androidfundamental.databinding.ActivityMainBinding
import com.example.androidfundamental.model.Question

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private var questionList = mutableListOf<Question>()
    private lateinit var questionAdapter : QuestionListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareData()

        questionAdapter = QuestionListAdapter(this,questionList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = questionAdapter
    }

    private fun prepareData() {
        questionList.add(Question(id = 1,"1. Create “hello world” application"))
        questionList.add(Question(id = 2,"2. Change screen background color on different button click event"))
        questionList.add(Question(id = 3,"3. Navigate between one screen to another screen"))
        questionList.add(Question(id = 4,"4. Pass data from one screen to second screen"))
        questionList.add(Question(id = 5,"5. Design login and registration screen"))
        questionList.add(Question(id = 6,"6. What is R.java file"))
        questionList.add(Question(id = 7,"7. What is activity and activity lifecycle"))
        questionList.add(Question(id = 8,"8. What is fragment and fragment lifecycle"))
        questionList.add(Question(id = 9,"9. Activity to fragment and fragment to activity"))
    }
}