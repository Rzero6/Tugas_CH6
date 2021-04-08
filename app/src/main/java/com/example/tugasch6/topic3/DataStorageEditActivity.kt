package com.example.tugasch6.topic3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tugasch6.databinding.ActivityDataStorageEditBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlin.properties.Delegates

class DataStorageEditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDataStorageEditBinding
    private lateinit var mDB: BarangDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataStorageEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mDB = BarangDatabase.getInstance(this)
        val objectBarang = intent.getParcelableExtra<Barang>("barang")
        binding.nama.setText(objectBarang?.nama)
        binding.warna.setText(objectBarang?.warna)
        binding.jumlah.setText(objectBarang?.jumlah.toString())
        binding.save.setOnClickListener {
            objectBarang?.nama  = binding.nama.text.toString().trim()
            objectBarang?.warna = binding.warna.text.toString().trim()
            objectBarang?.jumlah = binding.jumlah.text.toString().toInt()

            GlobalScope.async {
                val result = mDB.barangDao().updateBarang(objectBarang!!)

                runOnUiThread {
                    if (result != 0) {
                        Toast.makeText(this@DataStorageEditActivity, "Sukses", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        Toast.makeText(this@DataStorageEditActivity, "Gagal", Toast.LENGTH_SHORT)
                            .show()
                    }
                    finish()
                }
            }
        }
        binding.cancel.setOnClickListener {
            finish()
        }
    }
}