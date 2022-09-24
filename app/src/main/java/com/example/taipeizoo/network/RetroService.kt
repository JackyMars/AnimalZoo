package com.example.taipeizoo.network

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RetroService {


    @GET("a3e2b221-75e0-45c1-8f97-75acbd43d613")
    fun getAnimalListFromApi(@Query("scope") scope:String,):Observable<ResultModel>


}