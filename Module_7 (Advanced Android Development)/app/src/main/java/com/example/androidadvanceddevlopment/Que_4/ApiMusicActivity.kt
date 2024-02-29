package com.example.androidadvanceddevlopment.Que_4

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidadvanceddevlopment.Que_4.Adapter.DataAdapter
import com.example.androidadvanceddevlopment.Que_4.Model.MyData
import com.example.androidadvanceddevlopment.Que_4.Model.Singer
import com.example.androidadvanceddevlopment.Que_4.Network.ApiClient
import com.example.androidadvanceddevlopment.R
import com.example.androidadvanceddevlopment.databinding.ActivityApiMusicBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiMusicActivity : AppCompatActivity() {

    private lateinit var binding: ActivityApiMusicBinding

    private var mediaPlayer: MediaPlayer? = null

    private var singerList = mutableListOf<Singer>()
    private lateinit var singerAdapter: ArrayAdapter<String>

    private lateinit var adapter: DataAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApiMusicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareSingerList()

        singerAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            singerList.map { it.name })
        binding.spSinger.adapter = singerAdapter

        binding.spSinger.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedSinger = singerList[position].name

                mediaPlayer?.let {
                    if (it.isPlaying) {
                        it.stop()
                        it.reset()
                        it.release()
                        mediaPlayer = null
                    }
                }

                fetchData(selectedSinger)
            }


            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
        fetchData(singerList.first().name)

    }

    private fun fetchData(selectedSinger: String) {
        ApiClient.init().getData(selectedSinger).enqueue(object : Callback<MyData> {
            override fun onResponse(call: Call<MyData>, response: Response<MyData>) {
                if (response.isSuccessful) {
                    var dataList = response.body()?.data
                    dataList?.let {
                        adapter = DataAdapter(applicationContext, dataList)
                        binding.recyclerView.adapter = adapter
                        binding.recyclerView.layoutManager = LinearLayoutManager(applicationContext)
                    }
                }
            }

            override fun onFailure(call: Call<MyData>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    private fun prepareSingerList() {
        singerList.add(Singer(1, "Eminem"))
        singerList.add(Singer(2, "Joeyy"))
        singerList.add(Singer(3, "Rihanna"))
        singerList.add(Singer(4, "GS Beats"))
        singerList.add(Singer(5, "Lilybelle"))
        singerList.add(Singer(6, "BELSIN"))
        singerList.add(Singer(7, "Akon"))
        singerList.add(Singer(8, "Alan Sdr"))

    }
}