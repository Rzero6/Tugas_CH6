package com.example.tugasch6.topic3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugasch6.databinding.ActivityDataStorageBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class DataStorageActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDataStorageBinding
    private lateinit var mDB : BarangDatabase
    private lateinit var adapter : AdapterDataStorage
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDataStorageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mDB = BarangDatabase.getInstance(this)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        binding.recyclerView.layoutManager=layoutManager
        fetchData()
        binding.floatingActionButton.setOnClickListener {
            startActivity(Intent(this,DataStorageAddActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        fetchData()
    }
    fun fetchData(){
        GlobalScope.launch {
            val listBarang = mDB.barangDao().getAllBarang()

            runOnUiThread {
                listBarang.let {
                    adapter = AdapterDataStorage(it!!)
                    binding.recyclerView.adapter=adapter
                }
            }

        }
    }
}