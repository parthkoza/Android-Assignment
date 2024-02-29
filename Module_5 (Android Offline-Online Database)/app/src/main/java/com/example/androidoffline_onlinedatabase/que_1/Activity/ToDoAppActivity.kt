package com.example.androidoffline_onlinedatabase.que_1.Activity

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidoffline_onlinedatabase.R
import com.example.androidoffline_onlinedatabase.databinding.ActivityToDoAppBinding
import com.example.androidoffline_onlinedatabase.que_1.Adapter.ToDoAdapter
import com.example.androidoffline_onlinedatabase.que_1.Database.TodoDatabase
import com.example.androidoffline_onlinedatabase.que_1.Model.Todo
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ToDoAppActivity : AppCompatActivity() {

    private lateinit var binding: ActivityToDoAppBinding

    private var db : TodoDatabase?=null

    private var todoList = mutableListOf<Todo>()
    private lateinit var completedTaskAdapter : ToDoAdapter
    private lateinit var upcomingTaskAdapter : ToDoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityToDoAppBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = TodoDatabase.getInstance(this)

        binding.btnAdd.setOnClickListener {
            startActivity(Intent(this,TodoAddActivity::class.java))
        }

        completedTaskAdapter = ToDoAdapter(this,todoList)
        binding.rvCompleted.adapter = completedTaskAdapter
        binding.rvCompleted.layoutManager = LinearLayoutManager(this)

        upcomingTaskAdapter = ToDoAdapter(this,todoList)
        binding.rvUpcoming.adapter = upcomingTaskAdapter
        binding.rvUpcoming.layoutManager = LinearLayoutManager(this)

        upcomingTaskAdapter.itemEditClickListener = {position, task ->
            var intent = Intent(this,TodoAddActivity::class.java)
            intent.putExtra("TASK",task)
            startActivity(intent)
        }

        upcomingTaskAdapter.itemDeleteClickListener = {position, task ->
            showAlertDialog(task, position)
        }
    }

    private fun showAlertDialog(task: Todo, position: Int) {
        var builder = AlertDialog.Builder(this)
        .setTitle("Delete")
            .setMessage("Are you sure you want to delete this task?")
            .setPositiveButton("Delete",DialogInterface.OnClickListener { dialog, which ->
                TodoDatabase.getInstance(this)?.todoDao()!!.deleteTask(task)
                Toast.makeText(this, "Task Deleted", Toast.LENGTH_SHORT).show()
                upcomingTaskAdapter.deleteItem(position)
            })
            .setNegativeButton("Cancel",DialogInterface.OnClickListener { dialog, which ->

            })
        var dialog = builder.create()
        dialog.show()
    }

    override fun onResume() {
        super.onResume()
        readCompletedTask()
        readUpcomingTask()
    }

    private fun readUpcomingTask() {
        var currentDate = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(Date())
        todoList = TodoDatabase.getInstance(this)?.todoDao()!!.getAllTasks()
            .filter { task -> task.date >= currentDate  && !task.isCompleted }
            .toMutableList()
        upcomingTaskAdapter.setItems(todoList)
    }

    private fun readCompletedTask() {
        val currentDate = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(Date())
        todoList = TodoDatabase.getInstance(this)?.todoDao()!!.getCompletedTasks()
            .filter { task -> task.isCompleted }
            .toMutableList()
        completedTaskAdapter.setItems(todoList)
        completedTaskAdapter.notifyDataSetChanged()
    }
}