package com.example.api_project

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.api_project.databinding.ItemSliderBinding
import com.example.api_project.homefragment.MainFragment

class ImgSliderAdapter(private val context: MainFragment, private val imgSlider: Array<Int>) : RecyclerView.Adapter<ImgSliderAdapter.ImgViewHolder>() {

    inner class ImgViewHolder(val binding: ItemSliderBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: Int){
            Glide.with(context)
                .load(item)
                .into(binding.itemImgSlider)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImgViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemSliderBinding.inflate(layoutInflater, parent, false)
        return ImgViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImgViewHolder, position: Int) {
        holder.bind(imgSlider[position])
    }

    override fun getItemCount(): Int {
        return imgSlider.size
    }
}