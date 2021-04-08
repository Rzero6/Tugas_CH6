package com.example.tugasch6.topic2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tugasch6.MainActivity
import com.example.tugasch6.databinding.ActivityHomePageBinding

class HomePageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPreferences = SharedPreferences(this)
        binding.button6.setOnClickListener {
            sharedPreferences.clearSharedPrefs()
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        }
        binding.button5.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }
}