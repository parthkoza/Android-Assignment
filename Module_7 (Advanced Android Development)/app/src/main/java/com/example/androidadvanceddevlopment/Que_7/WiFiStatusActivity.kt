package com.example.androidadvanceddevlopment.Que_7

import android.content.Context
import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidadvanceddevlopment.R
import com.example.androidadvanceddevlopment.databinding.ActivityWiFiStatusBinding

class WiFiStatusActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWiFiStatusBinding
    private lateinit var wifiManager: WifiManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWiFiStatusBinding.inflate(layoutInflater)
        setContentView(binding.root)

        wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager

        binding.wifiToggle.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked){
                enableWifi()
            }else{
                disableWifi()
            }
        }

        binding.wifiToggle.isChecked = wifiManager.isWifiEnabled
    }

    private fun disableWifi() {
        wifiManager.isWifiEnabled = false
    }

    private fun enableWifi() {
        wifiManager.isWifiEnabled = true
    }
}