package com.example.androidfundamental.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var name: String?,
    var email: String?,
    var age: Int? =0
):Parcelable
