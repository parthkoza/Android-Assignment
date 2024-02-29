package com.example.androidoffline_onlinedatabase.que_5

import android.Manifest.permission.CAMERA
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.androidoffline_onlinedatabase.databinding.ActivityPhotoAddBinding

class PhotoAddActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPhotoAddBinding

    private var galleryLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if (it.resultCode == RESULT_OK){

            // Handle the selected image from the gallery
            var selectedImageURI = it.data?.data

            // Update the ImageView with the selected image
            binding.imageView.setImageURI(selectedImageURI)
        }
    }

    private var cameraLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){

        if (it.resultCode == RESULT_OK){

            // Check if the data contains the captured image
            val imageBitmap = it.data?.extras?.get("data") as? Bitmap

            if (imageBitmap != null){
                // Update the ImageView with the captured image
                binding.imageView.setImageBitmap(imageBitmap)
            }else{
                // Handle the case where the imageBitmap is null (no image captured)
                Toast.makeText(this, "Failed to capture image", Toast.LENGTH_SHORT).show()
            }
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhotoAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGallery.setOnClickListener {
            // Launch the gallery intent
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