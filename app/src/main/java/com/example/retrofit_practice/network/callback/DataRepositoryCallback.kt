package com.example.retrofit_practice.network.callback

/**
 * Created by hilma on 17/09/2020.
 */
interface DataRepositoryCallback<T> {
    fun onDataLoad(data: T?)
    fun onDataError(message: String?)
}