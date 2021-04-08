package com.example.tugasch6.topic3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tugasch6.databinding.ActivityDataStorageAddBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class DataStorageAddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDataStorageAddBinding
    private lateinit var mDB: BarangDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDB = BarangDatabase.getInstance(this)!!
        binding = ActivityDataStorageAddBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.save.setOnClickListener {
            if (binding.nama.text.toString().trim().isNotEmpty() && binding.warna.text.toString().trim().isNotEmpty()) {

                val objectBarang = Barang(
                    null,
                    binding.nama.text.toString().trim(),
                    binding.warna.text.toString().trim(),
                    binding.jumlah.text.toString().toInt()
                )
                GlobalScope.async {
                    val result = mDB.barangDao().insertBarang(objectBarang)
                    runOnUiThread {
                        if (result != 0.toLong()) {
                            Toast.makeText(
                                this@DataStorageAddActivity,
                                "Sukses",
                                Toast.LENGTH_SHORT)
                                .show()
                        } else {
                            Toast.makeText(this@DataStorageAddActivity, "Gagal", Toast.LENGTH_SHORT)
                                .show()
                        }
                        finish()
                    }
                }
            }else {
                Toast.makeText(this,"tidak boleh kosong",Toast.LENGTH_SHORT).show()
            }
        }
        binding.cancel.setOnClickListener {
            finish()
        }


    }
}