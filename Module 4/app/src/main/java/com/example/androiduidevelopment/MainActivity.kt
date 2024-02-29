package com.example.androiduidevelopment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androiduidevelopment.adapter.QuestionListAdapter
import com.example.androiduidevelopment.databinding.ActivityMainBinding
import com.example.androiduidevelopment.model.Question

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var questionList = mutableListOf<Question>()
    private lateinit var questionAdapter : QuestionListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        prepareData()
        questionAdapter = QuestionListAdapter(this,questionList)
        binding.recyclerview.layoutManager=LinearLayoutManager(this)
        binding.recyclerview.adapter = questionAdapter
    }

    private fun prepareData() {
        questionList.add(
            Question(
                id = 1,
                question = "1. Create an application to take input number from user and print its reverse number in TextView without button."
            )
        )
        questionList.add(
            Question(
                id = 2,
                question = "2. Create an application to input 2 numbers from user and all numbers between those 2 numbers in next activity "
            )
        )
        questionList.add(
            Question(
                id = 3,
                question = "3. Create an application with radio buttons (Add, Subtraction, Multiply,Division) EditText (number1, number2) and print result as per user choice from radio button in TextView"
            )
        )
        questionList.add(
            Question(
                id = 4,
                question = "4. Write a code to display login form when click on login button and registration form when click on registration button on single activity using fragment"
            )
        )
        questionList.add(
            Question(
                id = 5,
                question = "5. Create an application to load google url into webview also manage forward and backward redirect"
            )
        )
        questionList.add(
            Question(
                id = 6,
                question = "6. In Previous Practical write code to check weather internet connection is available or not  "
            )
        )
        questionList.add(
            Question(
                id = 7,
                question = "7.if  no internet connection then display message accordingly "
            )
        )
        questionList.add(
            Question(
                id = 8,
                question = "8. create an application to hide TextView when first button click and show when second button click "
            )
        )
        questionList.add(
            Question(
                id = 9,
                question = "9. Create an application to add TextView in TableLayout Programmatically"
            )
        )
        questionList.add(
            Question(
                id = 10,
                question = "10. create an application to open pdf using implicit intent "
            )
        )
        questionList.add(
            Question(
                id = 11,
                question = "11. create an application to increase font size when plus button click and decrease when minus button click "
            )
        )

        questionList.add(
            Question(
                id = 12,
                question = "12. create an application to display n edittext where n is number input by user"
            )
        )
        questionList.add(
            Question(
                id = 13,
                question = "13. Create an application to display Textview when checkbox is checked and hide otherwise A6 Write a program to show four images around Textview. "
            )
        )
        questionList.add(
            Question(
                id = 14,
                question = "14. Write a program to create one string array in string.xml file and that array show in listview"
            )
        )
        questionList.add(
            Question(
                id = 15,
                question = "15. Write a program in android display screen color which the Color will be select from the radio button."
            )
        )
        questionList.add(
            Question(
                id = 16,
                question = "16. Write a program you have taken three seek bar controls. From three Seekbar which Seek bar value changed the background color of device will be changed."
            )
        )
        questionList.add(
            Question(
                id = 17,
                question = "17. Create custom toolbar as per given below design"
            )
        )
        questionList.add(
            Question(
                id = 18,
                question = "18. Create toolbar with spinner and search functionality"
            )
        )
    }


}