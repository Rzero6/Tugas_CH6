package com.example.tugasch6.topic3

import android.app.AlertDialog
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.tugasch6.databinding.DataStorageItemBinding
import com.example.tugasch6.databinding.RecyclerViewItemBinding
import com.example.tugasch6.topic1.ImageData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.util.ArrayList

class AdapterDataStorage(val data : List<Barang>) : RecyclerView.Adapter<AdapterDataStorage.ViewHolder>() {
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
                val intentToEditActivity = Intent(it.context, DataStorageEditActivity::class.java)
                intentToEditActivity.putExtra("barang", data)
                it.context.startActivity(intentToEditActivity)
            }
            binding.btnDelete.setOnClickListener {
                val dialog = androidx.appcompat.app.AlertDialog.Builder(it.context)
                    .setTitle("Konfirmasi Hapus")
                    .setMessage("Yakin mau hapus data ini?")
                dialog.setPositiveButton("Yaa") { _, _ ->
                    val mDb = BarangDatabase.getInstance(it.context)
                    GlobalScope.async {
                        val result = mDb.barangDao().deleteBarang(data.id!!)
                        (it.context as DataStorageActivity).runOnUiThread {
                                if (result != 0) {
                                    Toast.makeText(it.context, "Sukses", Toast.LENGTH_SHORT)
                                        .show()
                                } else {
                                    Toast.makeText(it.context, "Gagal", Toast.LENGTH_SHORT)
                                        .show()
                                }
                        }
                        (it.context as DataStorageActivity).fetchData()
                    }
                }

                dialog.setNegativeButton("Gk") { d, _ ->
                    d.dismiss()
                }
                dialog.create().show()
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