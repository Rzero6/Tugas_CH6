package com.example.tugasch6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tugasch6.databinding.ActivityMainBinding
import com.example.tugasch6.topic1.RecyclerViewActivity
import com.example.tugasch6.topic2.SplashScreenActivity
import com.example.tugasch6.topic3.DataStorageActivity
import com.example.tugasch6.topic4.MVPActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            startActivity(Intent(this,RecyclerViewActivity::class.java))
        }
        binding.button2.setOnClickListener {
            startActivity(Intent(this,SplashScreenActivity::class.java))
        }
        binding.button3.setOnClickListener {
            startActivity(Intent(this,DataStorageActivity::class.java))
        }
        binding.button4.setOnClickListener {
            startActivity(Intent(this,MVPActivity::class.java))
        }
    }
}