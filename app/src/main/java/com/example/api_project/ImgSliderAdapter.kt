package com.example.api_project

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.api_project.databinding.ItemSliderBinding


class ImgSliderAdapter(imgUrlList: List<String>) : RecyclerView.Adapter<ImgSliderAdapter.ImgViewHolder>() {

    private val itemlist = imgUrlList

    inner class ImgViewHolder(val binding: ItemSliderBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: String){
            Glide.with(binding.root.context)
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
        holder.bind(itemlist[position])
    }

    override fun getItemCount(): Int {
        Log.d("itemlist", "$itemlist")
        return itemlist.size

    }

}