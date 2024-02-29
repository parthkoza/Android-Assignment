package com.example.advancedandroiddevelopment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.advancedandroiddevelopment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var questionList = mutableListOf<Question>()
    private lateinit var questionListAdapter: QuestionAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareData()

        questionListAdapter = QuestionAdapter(this,questionList)
        binding.recyclerView.adapter = questionListAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun prepareData() {
        questionList.add(
            Question(
                1,
                "1. Pic selected from gallery or camera after login to application"
            )
        )
        questionList.add(
            Question(
                2,
                "2. Create an application to display Google map with current location also give \n" +
                        "options to change mode in map"
            )
        )
        questionList.add(
            Question(
                3,
                "3. Create an application to input address and display marker on that address"
            )
        )
        questionList.add(
            Question(
                4,
                "4. Create an application to suggest places as user type with help of Place autocomplete service provide by Google"
            )
        )
        questionList.add(
            Question(
                5,
                "5. Write a code to rotate image"
            )
        )
        questionList.add(
            Question(
                6,
                "6. Write a code to blink image"
            )
        )
        questionList.add(
            Question(
                7,
                "7. Write a code to move image from one place to another place"
            )
        )
        questionList.add(
            Question(
                8,
                "8.  Write a code to zoom in / out image using animation"
            )
        )
        questionList.add(
            Question(
                9,
                "9. Write a code to show progress frame by frame animation"
            )
        )
        questionList.add(
            Question(
                10,
                "10. set animation on splash screen with app logo."
            )
        )
    }

}