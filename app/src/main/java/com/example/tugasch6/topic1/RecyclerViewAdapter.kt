package com.example.tugasch6.topic1

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tugasch6.databinding.RecyclerViewItemBinding
import java.util.ArrayList

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    private var data = ArrayList<ImageData>()
    fun setData(imageData: List<ImageData>){
        data.clear()
        data.addAll(imageData)
        notifyDataSetChanged()
    }
    inner class ViewHolder(var binding: RecyclerViewItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindViewHolder(data: ImageData){
            data.image?.let { binding.imageView.setImageResource(it) }
        }
    }

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: RecyclerViewItemBinding= RecyclerViewItemBinding.inflate(inflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViewHolder(data[position])
    }

}