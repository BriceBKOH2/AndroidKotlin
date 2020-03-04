package com.briceb.learning_kotlin_android.List

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.briceb.learning_kotlin_android.R
import kotlinx.android.synthetic.main.item_movie.view.*

data class Movie(val title: String, val year: Int)

class MovieAdapter(private val list: MutableList<Movie>) : RecyclerView.Adapter<MovieViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(
            inflater,
            parent
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

}

class MovieViewHolder(inflater: LayoutInflater, parent: ViewGroup) : RecyclerView.ViewHolder(inflater.inflate(
    R.layout.item_movie, parent, false)) {

    fun bind(movie: Movie) {
        itemView.apply {
            itemView.list_title.text = movie.title
            itemView.list_year.text = movie.year.toString()
        }
    }

}