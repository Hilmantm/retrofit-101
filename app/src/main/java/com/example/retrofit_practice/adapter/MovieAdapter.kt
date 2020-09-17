package com.example.retrofit_practice.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit_practice.R
import com.example.retrofit_practice.models.Movie

/**
 * Created by hilma on 17/09/2020.
 */
class MovieAdapter(
    private val context: Context,
    private val movies: List<Movie>
): RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.movie_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bindItem(movies[position])
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val itemMovieTitle: TextView = view.findViewById(R.id.item_movie_title)
        private val itemMoviesRelease: TextView = view.findViewById(R.id.item_movie_release)

        fun bindItem(movie: Movie) {
            itemMovieTitle.text = movie.title
            itemMoviesRelease.text = movie.release_date
        }
    }
}