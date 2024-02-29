package com.example.androidoffline_onlinedatabase.que_4.Activity

import PrefManager
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidoffline_onlinedatabase.R
import com.example.androidoffline_onlinedatabase.databinding.ActivityProjectListBinding
import com.example.androidoffline_onlinedatabase.que_4.Adapter.ProjectAdapter
import com.example.androidoffline_onlinedatabase.que_4.Database.AppDatabase
import com.example.androidoffline_onlinedatabase.que_4.Model.Project

class ProjectListActivity : AppCompatActivity() {

    private lateinit var binding : ActivityProjectListBinding

    private var projectList = mutableListOf<Project>()
    private lateinit var projectAdapter : ProjectAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProjectListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolBar)

        projectAdapter = ProjectAdapter(this,projectList)
        binding.rvProjectList.adapter = projectAdapter
        binding.rvProjectList.layoutManager = LinearLayoutManager(this)

        projectAdapter.itemEditClickListener = {position, project ->
            var intent = Intent(this,ProjectActivity::class.java)
            intent.putExtra("PROJECT",project)
            startActivity(intent)
        }

        projectAdapter.itemDeleteClickListener = {position, project ->
            try {
                showCustomDialog(position,project)
            }catch (e:Exception){
                e.printStackTrace()
            }
        }

        binding.btnAdd.setOnClickListener {
            startActivity(Intent(this,ProjectActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        readProjectList()
    }

    private fun readProjectList() {
        projectList = AppDatabase.getInstance(this)?.projectDao()!!.getAllProject()
        projectAdapter.setItem(projectList)
    }

    private fun showCustomDialog(position: Int, project: Project) {
        var builder = AlertDialog.Builder(this)
        builder.setTitle("Delete ?")
            .setMessage("Are you sure you want to delete this cuisine?")
            .setPositiveButton("YES", DialogInterface.OnClickListener { dialog, which ->
                AppDatabase.getInstance(this)!!.projectDao().deleteProject(project)
                Toast.makeText(this, "Item Deleted...", Toast.LENGTH_SHORT).show()
                projectAdapter.deleteItem(position)
            }).setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which ->

            })

        var dialog =builder.create()
        dialog.show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.logout_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            R.id.btn_login -> {
                val manager = PrefManager(this)
                manager.updateLoginStatus(false)
                startActivity(Intent(this, LoginActivity::class.java))
                finish()

                return true
            }

            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }
}