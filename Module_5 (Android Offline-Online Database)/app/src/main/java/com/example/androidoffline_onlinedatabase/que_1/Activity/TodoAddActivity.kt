package com.example.androidoffline_onlinedatabase.que_1.Activity

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.androidoffline_onlinedatabase.databinding.ActivityTodoAddBinding
import com.example.androidoffline_onlinedatabase.que_1.Database.TodoDatabase
import com.example.androidoffline_onlinedatabase.que_1.Model.Todo
import java.util.Calendar
import kotlin.concurrent.thread

class TodoAddActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTodoAddBinding
    private var db: TodoDatabase? = null
    private var task: Todo? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodoAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = TodoDatabase.getInstance(this)

        task = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("TASK", Todo::class.java)
        } else {
            intent.getParcelableExtra("TASK")
        }

        task?.let {
            binding.btnSave.text = "Update Task"
            binding.etTitle.setText(it.title)
            binding.etDesc.setText(it.desc)

        }

        binding.btnSave.setOnClickListener {
            var title = binding.etTitle.text.toString().trim()
            var desc = binding.etDesc.text.toString().trim()
            var date = binding.etDate.text.toString().trim()

            updateRecord(title, desc, date)

        }

        binding.ivCalender.setOnClickListener {
            showDatePickerDialog()
        }
    }

    private fun updateRecord(title: String, desc: String, date: String) {
        var message = ""

        thread(start = true) {
            var taskObjects = Todo(
                title = title, desc = desc, date = date,
                id = if (task != null) task!!.id else 0,
                createdAt = if (task != null) task!!.createdAt else System.currentTimeMillis(),
                isCompleted = if (task != null && task!!.date>date) task!!.isCompleted else false
            )
            try {
                if (task != null) {
                    //update
                    taskObjects.isCompleted = !task!!.isCompleted
                    db!!.todoDao().updateTask(taskObjects)
                    message = "Record updated successfully"
                } else {
                    //add
                    db!!.todoDao().insertTodoTask(taskObjects)
                    message = "Record added successfully"
                }
                runOnUiThread {
                    Toast.makeText(this, "$message", Toast.LENGTH_SHORT).show()
                    onBackPressedDispatcher.onBackPressed()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun showDatePickerDialog() {
        var calender = Calendar.getInstance()
        var year = calender.get(Calendar.YEAR)
        var month = calender.get(Calendar.MONTH)
        var dayOfMonth = calender.get(Calendar.DAY_OF_MONTH)

        var datePicker = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { datePicker, year, month, dayOfMonth ->
                var date = "${dayOfMonth.toString().padStart(2, '0')}/${
                    (month + 1).toString().padStart(2, '0')
                }/$year"
                binding.etDate.setText(date)
            },
            year, month, dayOfMonth
        )
        datePicker.show()
    }
}