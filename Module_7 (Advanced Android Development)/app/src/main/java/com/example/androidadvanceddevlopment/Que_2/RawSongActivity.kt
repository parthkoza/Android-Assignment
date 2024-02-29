package com.example.androidadvanceddevlopment.Que_2

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ProgressBar
import android.widget.SeekBar
import com.example.androidadvanceddevlopment.R
import com.example.androidadvanceddevlopment.databinding.ActivityRawSongBinding

class RawSongActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRawSongBinding

    private var mediaPlayer: MediaPlayer? = null
    private var progressBar: ProgressBar? = null
    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRawSongBinding.inflate(layoutInflater)
        setContentView(binding.root)

        progressBar = binding.songProgressBar

        binding.btnPlay.setOnClickListener {
            playSong()
        }

        binding.btnPause.setOnClickListener {
            pauseSong()
        }



    }

    private fun pauseSong() {
        mediaPlayer?.pause()
    }

    private fun stopSong() {
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
        stopProgressBar()
    }

    private fun playSong() {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(this, R.raw.bloody_marry)
            mediaPlayer?.setOnCompletionListener {
                stopSong()
            }
            startProgressBar()

        }
        mediaPlayer?.start()
    }


    private fun startProgressBar() {
        handler.postDelayed(updateProgressBar, 100)
    }

    private fun stopProgressBar() {
        handler.removeCallbacks(updateProgressBar)
    }

    private var updateProgressBar = object : Runnable {
        override fun run() {
            mediaPlayer?.let {
                val progress = (it.currentPosition.toFloat() / it.duration * 100).toInt()
                progressBar?.progress = progress
            }
            handler.postDelayed(this, 100)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        stopSong()
    }
}