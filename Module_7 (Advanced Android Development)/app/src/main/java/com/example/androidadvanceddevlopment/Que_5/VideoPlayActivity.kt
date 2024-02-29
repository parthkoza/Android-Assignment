package com.example.androidadvanceddevlopment.Que_5

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PowerManager
import android.widget.MediaController
import com.example.androidadvanceddevlopment.R
import com.example.androidadvanceddevlopment.databinding.ActivityVideoPlayBinding

class VideoPlayActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVideoPlayBinding
    private var wakeLock: PowerManager.WakeLock? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoPlayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var videoPath = "android.resource://com.example.androidadvanceddevlopment/" + R.raw.video

        binding.videoView.setVideoPath(videoPath)
        binding.videoView.start()
        // Acquire WakeLock to keep the device awake during video playback
        acquireWakeLock()

        // Set up Play/Pause button click listener
        binding.btnPlay.setOnClickListener {
            if (binding.videoView.isPlaying) {
                binding.videoView.pause()
            } else {
                binding.videoView.start()
            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()

        // Release the WakeLock when the activity is destroyed
        releaseWakeLock()
    }

    private fun acquireWakeLock() {
        val powerManager = getSystemService(Context.POWER_SERVICE) as PowerManager
        wakeLock = powerManager.newWakeLock(
            PowerManager.FULL_WAKE_LOCK or PowerManager.ACQUIRE_CAUSES_WAKEUP,
            "MyApp:VideoPlaybackWakeLock"
        )
        wakeLock?.acquire()
    }

    private fun releaseWakeLock() {
        wakeLock?.release()
    }
}