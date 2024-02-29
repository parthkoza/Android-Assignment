package com.example.androidoffline_onlinedatabase.que_3.Activity

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.androidoffline_onlinedatabase.R
import com.example.androidoffline_onlinedatabase.databinding.ActivityAddTaskBinding
import com.example.androidoffline_onlinedatabase.que_3.Database.TaskAppDatabase
import com.example.androidoffline_onlinedatabase.que_3.Model.Task
import java.util.Calendar
import kotlin.concurrent.thread

class AddTaskActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddTaskBinding
    var db: TaskAppDatabase? = null
    private var task: Task? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = TaskAppDatabase.getInstance(this)

        task = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("TASK", Task::class.java)
        } else {
            intent.getParcelableExtra("TASK")
        }

        task?.let {
            binding.btnAdd.text = "Update Task"
            binding.etName.setText(it.name)
            binding.etDesc.setText(it.description)
            binding.etDate.setText(it.date)
            binding.etTime.setText(it.time)
            binding.etPriority.setText(it.priority)

        }

        binding.btnAdd.setOnClickListener {
            var name = binding.etName.text.toString().trim()
            var desc = binding.etDesc.text.toString().trim()
            var time = binding.etTime.text.toString().trim()
            var date = binding.etDate.text.toString().trim()
            var priority = binding.etPriority.text.toString().trim()

            updateTask(name, desc, time, date,priority)
        }
        binding.ivCalender.setOnClickListener {
            showDatePickerDialog()
        }
        binding.ivClock.setOnClickListener {
            showTimePickerDialog()
        }
    }

    private fun showTimePickerDialog() {
        var calender = Calendar.getInstance()
        var hourOfDay = calender.get(Calendar.HOUR_OF_DAY)
        var minute = calender.get(Calendar.MINUTE)

        var timePicker = TimePickerDialog(this,
            TimePickerDialog.OnTimeSetListener { timePicker, timeOfHour, minute ->
                var time = "${timeOfHour.toString().padStart(2,'0')}:${minute.toString().padStart(2,'0')}"
                binding.etTime.setText(time)
            },
            hourOfDay,
            minute,
            false
        )
        timePicker.show()
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

    private fun updateTask(name: String, desc: String, time: String, date: String,priority:String) {
        var message = ""

        thread(start = true) {
            var taskObject = Task(
                name = name, description = desc, date = date, time = time, priority = priority,
                id = if (task != null) task!!.id else 0,
                createdAt = if (task != null) task!!.createdAt else System.currentTimeMillis(),

            )

            try {
                if (task != null) {
                    //Update
                    db!!.taskDao().updateTask(taskObject)
                    message = "Task updated Successfully"
                } else {
                    //Insert
                    db!!.taskDao().insertTask(taskObject)
                    message = "Task added Successfully"
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

}