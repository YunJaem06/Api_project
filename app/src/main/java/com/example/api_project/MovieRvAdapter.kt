package com.example.api_project

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.api_project.moviedata.Movies
import com.example.api_project.databinding.ItemHomeMovieChartBinding

class MovieRvAdapter(val context: Context, private val movieList : ArrayList<Movies>) : RecyclerView.Adapter<MovieRvAdapter.MovieRvViewHolder>() {

   var itemList : ArrayList<Movies> = movieList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieRvViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemHomeMovieChartBinding.inflate(layoutInflater, parent, false)
        return MovieRvViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieRvViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class MovieRvViewHolder(private val binding: ItemHomeMovieChartBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Movies){
            binding.tvPosterName.text = item.name
            val url = "https://image.tmdb.org/t/p/w500" + item.img
            Glide.with(context)
                .load(url)
                .into(binding.ivMoviePoster)

            binding.tvEggPercent.text = item.egg_percent
            binding.tvPosterPercent.text = item.moviePercent
            binding.tvMoviePeopleCount.text = item.see_movie
            binding.tvPosterRank.text = item.rank.toString()
        }
    }
}