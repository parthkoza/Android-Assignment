package com.example.androiduidevelopment.que_17

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.androiduidevelopment.R
import com.example.androiduidevelopment.databinding.ActivityToolBarBinding

class ToolBarActivity : AppCompatActivity() {

    private lateinit var binding : ActivityToolBarBinding

    private var language= arrayListOf("Select language","PHP","C++","PYTHON","C","JAVA","KOTLIN","DART","JAVASCRIPT","FLUTTER","SWIFT","NODE","REACT")
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityToolBarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,language)
        binding.spinner.adapter = adapter






    }
}