package com.example.tugasch6.topic1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugasch6.R
import com.example.tugasch6.databinding.ActivityRecyclerViewBinding

class RecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val imageData = arrayListOf(
            ImageData(R.drawable.ic_baseline_account_circle_24),
            ImageData(R.drawable.ic_baseline_account_circle_24),
            ImageData(R.drawable.ic_baseline_account_circle_24),
            ImageData(R.drawable.ic_baseline_account_circle_24),
            ImageData(R.drawable.ic_baseline_account_circle_24),
            ImageData(R.drawable.ic_baseline_account_circle_24),
            ImageData(R.drawable.ic_baseline_account_circle_24),
            ImageData(R.drawable.ic_baseline_account_circle_24),
            ImageData(R.drawable.ic_baseline_account_circle_24),
            ImageData(R.drawable.ic_baseline_account_circle_24),
            ImageData(R.drawable.ic_baseline_account_circle_24),
            ImageData(R.drawable.ic_baseline_account_circle_24),
            ImageData(R.drawable.ic_baseline_account_circle_24),
            ImageData(R.drawable.ic_baseline_account_circle_24),
            ImageData(R.drawable.ic_baseline_account_circle_24),
            ImageData(R.drawable.ic_baseline_account_circle_24),
            ImageData(R.drawable.ic_baseline_account_circle_24),
            ImageData(R.drawable.ic_baseline_account_circle_24),
            ImageData(R.drawable.ic_baseline_account_circle_24),
            ImageData(R.drawable.ic_baseline_account_circle_24),
            ImageData(R.drawable.ic_baseline_account_circle_24)
        )
        val adapter = RecyclerViewAdapter()
        val layoutManager = GridLayoutManager(this,3)
        binding.recyclerView.layoutManager=layoutManager
        binding.recyclerView.adapter=adapter
        adapter.setData(imageData)

    }
}