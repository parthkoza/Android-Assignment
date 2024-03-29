package com.example.androidadvanceddevlopment.Que_4.Network

import com.example.androidadvanceddevlopment.Que_4.Interface.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class ApiClient {

    companion object {

        private var retrofit: Retrofit? = null

        fun init(): ApiService {
            if (retrofit == null){
                retrofit = Retrofit.Builder()
                    .baseUrl("https://deezerdevs-deezer.p.rapidapi.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!.create(ApiService::class.java)
        }
    }
}