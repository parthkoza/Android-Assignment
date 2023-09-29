package com.example.androidfundamental.que_8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidfundamental.R
import com.example.androidfundamental.databinding.ActivityQueEightBinding

class QueEightActivity : AppCompatActivity() {
    private lateinit var binding : ActivityQueEightBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQueEightBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvQueEight.text = "Que: What is fragment and fragment lifecycle?\nAns:\n" +
                "->In Android, the fragment is the part of Activity which represents a portion of User Interface(UI) on the screen. \n" +
                "->It is the modular section of the android activity that is very helpful in creating UI designs that are flexible in nature and auto-adjustable based on the device screen size. \n" +
                "->The UI flexibility on all devices improves the user experience and adaptability of the application. \n" +
                "->Fragments can exist only inside an activity as its lifecycle is dependent on the lifecycle of host activity. \n" +
                "->For example, if the host activity is paused, then all the methods and operations of the fragment related to that activity will stop functioning, thus fragment is also termed as sub-activity. \n" +
                "->Fragments can be added, removed, or replaced dynamically i.e., while activity is running. \n" +
                "\n\nFRAGMENT LIFECYCLE:"
    }
}