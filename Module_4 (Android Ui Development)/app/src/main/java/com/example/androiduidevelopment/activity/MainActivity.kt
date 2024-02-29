package com.example.androiduidevelopment.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androiduidevelopment.adapter.QuestionListAdapter
import com.example.androiduidevelopment.databinding.ActivityMainBinding
import com.example.androiduidevelopment.model.Question

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var questionList = mutableListOf<Question>()
    private lateinit var questionListAdapter: QuestionListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareData()

        questionListAdapter = QuestionListAdapter(this,questionList)
        binding.recyclerView.adapter = questionListAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun prepareData() {
        questionList.add(Question(
                1,
                "1. Create an application to take input number from user and print its reverse \n" +
                        "number in TextView without button. ")
        )
        questionList.add(Question(
                2,
                "2. Create an application to input 2 numbers from user and all numbers \n"+
                        "between those 2 numbers in next activity.")
        )
        questionList.add(Question(
                3,
                "3. Create an application with radio buttons (Add, Subtraction, Multiply,Division) \n" +
                        " EditText (number1, number2) and print result as per user choice \n" +
                        "from radio button in TextView")
        )
        questionList.add(Question(
                4,
                "4. Write a code to display login form when click on login button and \n"+
                        "registration form when click on registration button on single activity using fragment")
        )
        questionList.add(Question(
                5,
                "5. Create an application to load google url into webview also manage forward \n" +
                        "and backward redirect ")
        )
        questionList.add(Question(
                6,
                "6. In Previous Practical write code to check weather internet connection is \n" +
                        "available or not if \n" + " no internet connection then display message accordingly")
        )
        questionList.add(Question(
                7,
                "7. create an application to hide TextView when first button click and show \n" +
                        "when second button click")
        )
        questionList.add(Question(
                8,
                "8. Create an application to add TextView in TableLayout Programmatically")
        )
        questionList.add(Question(
                9,
                "9. create an application to open pdf using implicit intent ")
        )
        questionList.add(Question(
                10,
                "10. create an application to increase font size when plus button click and \n" +
                        "decrease when minus button click ")
        )
        questionList.add(Question(
                11,
                "11. create an application to display n edittext where n is number input by user.")
        )
        questionList.add(Question(
                12,
                "12. Create an application to display Textview when checkbox is checked and \n" +
                        "hide otherwise ")
        )
        questionList.add(Question(
                13,
                "13. A6 Write a program to show four images around Textview. ")
        )
        questionList.add(Question(
                14,
                "14. Write a program to create one string array in string.xml file and that array \n" +
                        "show in listview. ")
        )
        questionList.add(Question(
                15,
                "15. Write a program in android display screen color which the Color will be \n" +
                        "select from the radio button. ")
        )
        questionList.add(Question(
                16,
                "16. Write a program you have taken three seek bar controls. From three Seekbar \n" +
                        "which Seek bar value changed the background color of device will be \n" +
                        "changed. ")
        )
        questionList.add(Question(
                17,
                "17. Create custom toolbar as per given below design \n" +
                        " Create toolbar with spinner and search functionality \n")
        )
    }
}