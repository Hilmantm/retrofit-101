package com.example.retrofit_practice.network

import com.example.retrofit_practice.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by hilma on 17/09/2020.
 */
class Retrofit {
    private val retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val dataManager: Service = retrofit.create(Service::class.java)
}