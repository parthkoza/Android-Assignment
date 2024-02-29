package com.example.androidadvanceddevlopment.Que_4.Interface

import com.example.androidadvanceddevlopment.Que_4.Model.MyData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

    @Headers(
        "X-RapidAPI-Key: 78f25f6b80msha888adc39abf6cbp1ef97cjsn2123e73af60e",
        "X-RapidAPI-Host: deezerdevs-deezer.p.rapidapi.com"
    )
    @GET("search")
    fun getData(@Query("q") singer:String):Call<MyData>
}