package com.example.androidadvanceddevlopment.Que_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import com.example.androidadvanceddevlopment.databinding.ActivityTextToSpeechBinding
import java.util.Locale

class TextToSpeechActivity : AppCompatActivity(),TextToSpeech.OnInitListener {

    private lateinit var textToSpeech : TextToSpeech
    private lateinit var binding: ActivityTextToSpeechBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTextToSpeechBinding.inflate(layoutInflater)
        setContentView(binding.root)

        textToSpeech = TextToSpeech(this,this)

        binding.btnSpeak.setOnClickListener {
            var textToRead =  binding.etText.text.toString().trim()

            if (textToRead.isNotEmpty()){
                speakText(textToRead)
            }
        }
    }

    private fun speakText(textToRead: String) {
        textToSpeech.speak(textToRead,TextToSpeech.QUEUE_FLUSH,null,null)
    }
    override fun onDestroy() {
        // Shutdown TextToSpeech when the activity is destroyed to free up resources.
        if (textToSpeech.isSpeaking) {
            textToSpeech.stop()
        }
        textToSpeech.shutdown()
        super.onDestroy()
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS){
            var result = textToSpeech.setLanguage(Locale.ENGLISH)

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){

            }else{

            }
        }
    }
}