package com.example.androidoffline_onlinedatabase.que_4.Network

import com.example.androidoffline_onlinedatabase.que_4.Interface.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object{

        private var retrofit: Retrofit? = null

        fun init(): ApiService {
            if (retrofit == null){
                retrofit = Retrofit.Builder()
                    .baseUrl("http://172.20.10.6/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!.create(ApiService::class.java)
        }

    }
}