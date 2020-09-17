package com.example.retrofit_practice

import com.example.retrofit_practice.models.Movie
import com.example.retrofit_practice.models.Response
import com.example.retrofit_practice.network.callback.DataRepositoryCallback
import com.example.retrofit_practice.network.callback.ResultCallback
import com.example.retrofit_practice.network.repository.DataRepository

/**
 * Created by hilma on 17/09/2020.
 */
class MainActivityPresenter(
    private val view: ResultCallback<Response<Movie>>,
    private val dataRepository: DataRepository
) {
    fun getMovies() {
        view.showLoading()
        dataRepository.getMovies(object: DataRepositoryCallback<Response<Movie>> {
            override fun onDataLoad(data: Response<Movie>?) {
                view.hideLoading()
                view.onDataLoad(data)
            }

            override fun onDataError(message: String?) {
                view.onDataError(message)
            }
        })
    }
}