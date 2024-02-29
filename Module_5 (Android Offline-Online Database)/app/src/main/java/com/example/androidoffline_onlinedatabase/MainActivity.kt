package com.example.androidoffline_onlinedatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidoffline_onlinedatabase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var questionList = mutableListOf<Question>()
    private lateinit var questionListAdapter: QuestionListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareData()

        questionListAdapter = QuestionListAdapter(this, questionList)
        binding.recyclerView.adapter = questionListAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun prepareData() {
        questionList.add(
            Question(
                1,
                "1. Create an application of todo app using SQLite with function lite to create \n" +
                        "list of upcoming task, completed task, remove task, update task in daily \n" +
                        "activity. "
            )
        )
        questionList.add(
            Question(
                2,
                "2. Create a Sticky Notes app with proper customization which can \n" +
                        "insert,view,update,delete using SQLite database"
            )
        )
        questionList.add(
            Question(
                3,
                "3. To create task management application for adding, updating, deleting the task \n" +
                        "and show the tasks in the listview or gridview. Task have name, description, \n" +
                        "date, time, priority. Sort the task by the date and time wise. If task is due then \n" +
                        "automatically show as blue color. It will search the tasks by date wise. If high \n" +
                        "priority then show as red color, average priority as blue color, low priority as \n" +
                        "green color. Select specified item an open context menu to select “Complete \n" +
                        "the Task” then this task "
            )
        )
        questionList.add(
            Question(
                4,
                "4. Create an application in which employee can login and register with MySQL \n" +
                        "database \n" +
                        "after logging employee can insert, update and delete \n" +
                        "project details Create an application to select employee profile page in which \n" +
                        "employee can upload"
            )
        )
        questionList.add(
            Question(
                5,
                "5. pic selected from gallery or camera after login to application."
            )
        )
    }
}