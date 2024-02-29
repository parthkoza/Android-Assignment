package com.example.androidoffline_onlinedatabase.que_4.Activity

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.androidoffline_onlinedatabase.R
import com.example.androidoffline_onlinedatabase.databinding.ActivityProjectBinding
import com.example.androidoffline_onlinedatabase.que_4.Database.AppDatabase
import com.example.androidoffline_onlinedatabase.que_4.Model.Project
import kotlin.concurrent.thread

class ProjectActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProjectBinding

    private var db: AppDatabase? = null
    private var project: Project? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProjectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = AppDatabase.getInstance(this)

        project = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("PROJECT", Project::class.java)
        } else {
            intent.getParcelableExtra("PROJECT")
        }

        project?.let {
            //Update
            binding.btnAddProject.text = "Update Project"
            binding.etProjectTitle.setText(it.projectTitle)
            binding.etDesc.setText(it.projectDesc)

        }
        binding.btnAddProject.setOnClickListener {
            var title = binding.etProjectTitle.text.toString().trim()
            var desc = binding.etDesc.text.toString().trim()

            updateProject(title, desc)
        }

    }

    private fun updateProject(title: String, desc: String) {
        var message = ""

        thread(start = true) {
            var projectObject = Project(
                projectTitle = title,
                projectDesc = desc,
                id = if (project != null) project!!.id else 0,
                createdAt = if (project != null) project!!.createdAt else System.currentTimeMillis()
            )

            try {
                if (project != null) {
                    //Update
                    db!!.projectDao().updateProject(projectObject)
                    message = "Record Update Successfully"
                } else {
                    //Add
                    db!!.projectDao().insertProject(projectObject)
                    message = "Record Added Successfully"
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