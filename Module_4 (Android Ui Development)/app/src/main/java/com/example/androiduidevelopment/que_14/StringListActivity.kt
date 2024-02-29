package com.example.androiduidevelopment.que_14

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.androiduidevelopment.R
import com.example.androiduidevelopment.databinding.ActivityStringListBinding

class StringListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStringListBinding

    private lateinit var colorAdapter : ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStringListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val myArray = resources.getStringArray(R.array.ColorList)

        colorAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, myArray)
        binding.listView.adapter = colorAdapter

        binding.listView.setOnItemClickListener { adapterView, view, position, id ->

            var color = myArray[position]
            Toast.makeText(this, "$color", Toast.LENGTH_SHORT).show()
        }
    }
}