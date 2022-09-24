package com.example.taipeizoo.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {
    companion object{
        val baseURL = "https://data.taipei/api/v1/dataset/" //a3e2b221-75e0-45c1-8f97-75acbd43d613?scope=resourceAquire&limit=1000

        fun getRetroInstance():Retrofit{

            return Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        }
    }
}