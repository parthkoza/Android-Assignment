package com.example.advancedandroiddevelopment.que1

import android.Manifest.permission.CAMERA
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.example.advancedandroiddevelopment.R
import com.example.advancedandroiddevelopment.databinding.ActivityImageBinding

class ImageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityImageBinding

    private var galleryLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if (it.resultCode == RESULT_OK){

            // Handle the selected image from the galley
            var selectedImageURI = it.data?.data

            //Update the ImageView with the selected image
            binding.imageView.setImageURI(selectedImageURI)
        }
    }

    private var cameraLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if (it.resultCode == RESULT_OK){
            val imageBitmap = it.data?.extras?.get("data") as? Bitmap

            if (imageBitmap != null){
                binding.imageView.setImageBitmap(imageBitmap)
            }else{
                Toast.makeText(this, "Failed to capture image", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGallery.setOnClickListener {
            //Check if the camera permission is granted
            val galleryIntent = Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            galleryLauncher.launch(galleryIntent)
        }
        binding.btnCamera.setOnClickListener {
            // Check if the camera permission is granted
            if (ContextCompat.checkSelfPermission(this,CAMERA)==PackageManager.PERMISSION_GRANTED){
                // Permission is already granted, launch the camera intent
                val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                cameraLauncher.launch(cameraIntent)
            }else{
                // Permission is not granted, request it
                cameraPermissionLauncher.launch(CAMERA)
            }
        }

    }
    private val cameraPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()){
        if (it){
            // Permission is granted, launch the camera intent
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            cameraLauncher.launch(cameraIntent)
        }else{
            // Permission is denied, handle accordingly (show a message, request again, etc.)
            Toast.makeText(this, "Camera permission denied", Toast.LENGTH_SHORT).show()
        }
    }

}