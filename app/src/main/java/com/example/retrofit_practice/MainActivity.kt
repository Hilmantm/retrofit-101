package com.example.retrofit_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit_practice.adapter.MovieAdapter
import com.example.retrofit_practice.models.Movie
import com.example.retrofit_practice.models.Response
import com.example.retrofit_practice.network.callback.ResultCallback
import com.example.retrofit_practice.network.repository.DataRepository

class MainActivity : AppCompatActivity(), ResultCallback<Response<Movie>> {

    private lateinit var rvMovie: RecyclerView
    private lateinit var pbMovie: ProgressBar
    private lateinit var movieAdapter: MovieAdapter
    private lateinit var mainActivityPresenter: MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvMovie = findViewById(R.id.rv_movie)
        pbMovie = findViewById(R.id.pb_movie)
        rvMovie.layoutManager = LinearLayoutManager(this)
        mainActivityPresenter = MainActivityPresenter(this, DataRepository())
        mainActivityPresenter.getMovies()
    }

    override fun showLoading() {
        pbMovie.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        pbMovie.visibility = View.GONE
    }

    override fun onDataLoad(data: Response<Movie>?) {
        if(data != null) {
            movieAdapter = MovieAdapter(this@MainActivity, data.results)
            rvMovie.adapter = movieAdapter
        }
    }

    override fun onDataError(message: String?) {
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
    }

}