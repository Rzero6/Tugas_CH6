package com.example.tugasch6.topic4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugasch6.databinding.ActivityMVPBinding
import com.example.tugasch6.databinding.EditDialogBinding
import com.example.tugasch6.topic3.Barang
import com.example.tugasch6.topic3.BarangDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MVPActivity : AppCompatActivity(), MVPView {
    private lateinit var  binding : ActivityMVPBinding
    private lateinit var adapter: Adapter
    private lateinit var presenter : MVPPresenterImp
    private val barangData: MutableList<Barang> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMVPBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = Adapter(barangData)
        val database = BarangDatabase.getInstance(this)
        presenter= MVPPresenterImp(this,database.barangDao())
        presenter.getData()
        binding.recyclerViewMVP.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.recyclerViewMVP.adapter=adapter
        binding.floatingActionButton.setOnClickListener {
            showAddDialog()
        }
        adapter.setOnDeleteClick {
            showConfirmationDeleteDialog(it)
        }
        adapter.setOnEditClick {
            showEditDialog(it)
        }

    }
    private fun showAddDialog() {
        val builder = AlertDialog.Builder(this)
        val view = EditDialogBinding.inflate(layoutInflater)
        builder.setView(view.root)
        val dialog = builder.create()
        view.cancelButton.setOnClickListener {
            dialog.dismiss()
        }
        view.saveButton.setOnClickListener {
            val nama = view.etEditTitle.text.toString().trim()
            val warna = view.warna.text.toString().trim()
            val jumlah = view.jumlah.text.toString().toInt()
            val barang = Barang(null, nama, warna,jumlah)
            presenter.addData(barang)
            dialog.dismiss()
        }
        dialog.show()
    }
    private fun showEditDialog(barang: Barang) {
        val builder = AlertDialog.Builder(this)
        val view = EditDialogBinding.inflate(layoutInflater)
        builder.setView(view.root)
        val dialog = builder.create()
        view.etEditTitle.setText(barang.nama)
        view.warna.setText(barang.warna)
        view.jumlah.setText(barang.jumlah.toString().trim())
        view.cancelButton.setOnClickListener {
            dialog.dismiss()
        }
        view.saveButton.setOnClickListener {
            val nama = view.etEditTitle.text.toString().trim()
            val warna = view.warna.text.toString().trim()
            val jumlah = view.jumlah.text.toString().toInt()
            val barang = Barang(barang.id, nama, warna,jumlah)
            presenter.updData(barang)
            dialog.dismiss()
        }
        dialog.show()
    }
    private fun showConfirmationDeleteDialog(id: Int?) {
        val dialog = AlertDialog.Builder(this)
            .setTitle("Konfirmasi Hapus")
            .setMessage("Yakin mau hapus data ini?")
        dialog.setPositiveButton("Yaa") { _, _ ->
            presenter.removeData(id!!)
        }
        dialog.setNegativeButton("Gk") { d, _ ->
            d.dismiss()
        }
        dialog.create().show()
    }
    override fun showData(data: List<Barang>?) {
        GlobalScope.launch(Dispatchers.Main) {
            data?.let {
                barangData.clear()
                barangData.addAll(it)
                adapter.notifyDataSetChanged()
            }
        }
    }
}