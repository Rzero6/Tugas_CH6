package com.example.tugasch6.topic4

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.tugasch6.databinding.DataStorageItemBinding
import com.example.tugasch6.topic3.Barang
import com.example.tugasch6.topic3.BarangDatabase
import com.example.tugasch6.topic3.DataStorageActivity
import com.example.tugasch6.topic3.DataStorageEditActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class Adapter(val data: List<Barang>) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    private lateinit var onDeleteClick: (Int?) -> Unit
    private lateinit var onEditClick: (Barang) -> Unit

    fun setOnDeleteClick(onClick: (Int?) -> Unit) {
        this.onDeleteClick = onClick
    }

    fun setOnEditClick(onClick: (Barang) -> Unit) {
        this.onEditClick = onClick
    }

    inner class ViewHolder(var binding: DataStorageItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindViewHolder(data: Barang) {
            binding.titleTextView.text = data.nama
            binding.contentTextView.text = data.warna
            binding.jumlah.text = data.jumlah.toString().trim()
            binding.btnEdit.setOnClickListener {
                onEditClick(data)
            }
            binding.btnDelete.setOnClickListener {
                onDeleteClick(data.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: DataStorageItemBinding =
            DataStorageItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViewHolder(data[position])
    }

    override fun getItemCount(): Int = data.size

}