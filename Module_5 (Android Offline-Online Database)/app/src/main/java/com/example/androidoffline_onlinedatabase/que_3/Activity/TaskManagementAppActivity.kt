package com.example.androidoffline_onlinedatabase.que_3.Activity

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidoffline_onlinedatabase.databinding.ActivityTaskManagementAppBinding
import com.example.androidoffline_onlinedatabase.que_3.Adapter.TaskAdapter
import com.example.androidoffline_onlinedatabase.que_3.Database.TaskAppDatabase
import com.example.androidoffline_onlinedatabase.que_3.Model.Task

class TaskManagementAppActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTaskManagementAppBinding
    private var taskList = mutableListOf<Task>()
    private lateinit var taskAdapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaskManagementAppBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            startActivity(Intent(this, AddTaskActivity::class.java))
        }

        taskAdapter = TaskAdapter(this,taskList)
        binding.listView.adapter = taskAdapter
        binding.listView.layoutManager = LinearLayoutManager(this)

        taskAdapter.btneditclicklistener={position, task ->
            var intent = Intent(this, AddTaskActivity::class.java)
            intent.putExtra("TASK", task)
            startActivity(intent)
        }
        taskAdapter.btnDeleteClickListener = { position, task ->
            showAlertDialog(task, position)
        }
    }

    private fun readTaskList() {
        taskList = TaskAppDatabase.getInstance(this)?.taskDao()!!.getAllTasks()
        taskAdapter.setItems(taskList)
    }
    override fun onResume() {
        super.onResume()
        readTaskList()
    }
    private fun showAlertDialog(task: Task, position: Int) {
        var builder = AlertDialog.Builder(this)
        builder.setTitle("Delete")
        builder.setMessage("Are you sure you want to delete this task?")
        builder.setPositiveButton("Delete", DialogInterface.OnClickListener { dialog, which ->
            TaskAppDatabase.getInstance(this)?.taskDao()!!.deleteTask(task)
            Toast.makeText(this, "Item deleted", Toast.LENGTH_SHORT).show()
            taskAdapter.deleteItem(position)
        })
        builder.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which ->

        })
        var dialog = builder.create()
        dialog.show()


    }
}