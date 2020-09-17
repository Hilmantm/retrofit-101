package com.example.retrofit_practice.network.repository

import com.example.retrofit_practice.BuildConfig
import com.example.retrofit_practice.models.Movie
import com.example.retrofit_practice.models.Response
import com.example.retrofit_practice.network.Retrofit
import com.example.retrofit_practice.network.Service
import com.example.retrofit_practice.network.callback.DataRepositoryCallback
import retrofit2.Call
import retrofit2.Callback

/**
 * Created by hilma on 17/09/2020.
 */
class DataRepository {

    private val dataManager: Service = Retrofit().dataManager
    private val apiKey = BuildConfig.API_KEY

    fun getMovies(callback: DataRepositoryCallback<Response<Movie>>) {
        dataManager.getMovies(apiKey).enqueue(object: Callback<Response<Movie>> {
            override fun onFailure(call: Call<Response<Movie>>, t: Throwable) {
                callback.onDataError(t.message.toString())
            }

            override fun onResponse(
                call: Call<Response<Movie>>,
                response: retrofit2.Response<Response<Movie>>
            ) {
                response.let {
                    if(it.isSuccessful) {
                        callback.onDataLoad(it.body())
                    } else {
                        callback.onDataError(it.message().toString())
                    }
                }
            }
        })
    }
}