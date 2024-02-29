package com.example.androidoffline_onlinedatabase.que_4.Interface

import RegisterResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("student.php")
    fun create(
        @Field("flag") flag: Int,
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("mobile") contact: String
    ): Call<RegisterResponse>

    @FormUrlEncoded
    @POST("student.php")
    fun loggedIn(
        @Field("flag") flag: Int,
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<RegisterResponse>

}