package com.example.androidadvanceddevlopment.Que_3

import android.app.Activity
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import com.example.androidadvanceddevlopment.R
import com.example.androidadvanceddevlopment.databinding.ActivityPlaySongFromMemoryBinding
import java.util.Timer
import java.util.TimerTask

class PlaySongFromMemoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlaySongFromMemoryBinding
    private var mediaPlayer: MediaPlayer? = null
    private var isPlaying = false

    private var pickSongLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                it.data?.data.let { it ->
                    playSong(it!!)
                }
            }
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlaySongFromMemoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView.setOnClickListener {
            pickSong()
        }
        setUpClickListeners()
    }

    private fun setUpClickListeners() {
        binding.btnPause.setOnClickListener { onPauseButtonClick() }
    }

    private fun onPauseButtonClick() {
        mediaPlayer!!.pause()
        showPlayImage()
        isPlaying = false
    }

    private fun pickSong() {
        var intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            type = "audio/*"
        }
        pickSongLauncher.launch(intent)
    }

    private fun playSong(uri: Uri) {
        mediaPlayer?.release()
        mediaPlayer = MediaPlayer().apply {
            setDataSource(this@PlaySongFromMemoryActivity, uri)
            prepare()
            start()
            this@PlaySongFromMemoryActivity.isPlaying = true
            showPlayImage()
            mediaPlayer?.seekTo(0)
            binding.progressBar.progress = 0
        }

        mediaPlayer!!.setOnPreparedListener {
            binding.progressBar.max = mediaPlayer!!.duration
            binding.progressBar.progress = 0
        }

        Timer().scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    if (isPlaying) {
                        binding.progressBar.progress = mediaPlayer!!.currentPosition
                    }
                }
            }

        }, 0, 1000)

        binding.progressBar.setOnTouchListener { view, motionEvent ->
            onProgressBarClick(motionEvent)
            true
        }

        showPauseImage()

        binding.play.setOnClickListener {
            if (mediaPlayer?.isPlaying == true){
                mediaPlayer!!.pause()
            }else{
                mediaPlayer!!.start()
            }
            showPauseImage()
        }
    }

    private fun onProgressBarClick(motionEvent: MotionEvent) {
        var newPosition = (motionEvent.x / binding.progressBar.width) * binding.progressBar.max
        mediaPlayer!!.seekTo(newPosition.toInt())
        binding.progressBar.progress = newPosition.toInt()
    }

    private fun showPlayImage() {
        binding.play.visibility = View.VISIBLE
        binding.btnPause.visibility = View.GONE
    }

    private fun showPauseImage() {
        binding.btnPause.visibility = View.VISIBLE
        binding.play.visibility = View.GONE
    }

}