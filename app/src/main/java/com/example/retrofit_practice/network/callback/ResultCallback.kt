package com.example.retrofit_practice.network.callback

/**
 * Created by hilma on 17/09/2020.
 */
interface ResultCallback<T>: DataRepositoryCallback<T> {
    fun showLoading()
    fun hideLoading()
}