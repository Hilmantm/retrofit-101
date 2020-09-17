package com.example.retrofit_practice.network

import com.example.retrofit_practice.models.Movie
import com.example.retrofit_practice.models.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by hilma on 17/09/2020.
 */
interface Service {
    @GET("movie/popular")
    fun getMovies(
        @Query("api_key") apiKey: String
    ) : Call<Response<Movie>>
}