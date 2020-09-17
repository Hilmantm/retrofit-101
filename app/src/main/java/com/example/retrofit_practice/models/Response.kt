package com.example.retrofit_practice.models

/**
 * Created by hilma on 17/09/2020.
 */
class Response<T>(
    var page: Int,
    var total_results: Int,
    var total_pages: Int,
    var results: List<T> = listOf()
)