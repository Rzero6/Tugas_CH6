package com.example.tugasch6.topic2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tugasch6.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPreferences = SharedPreferences(this)

        binding.login.setOnClickListener {
            if (binding.editTextTextPersonName.text.isNotEmpty() && binding.editTextTextPassword.text.isNotEmpty()) {
                if (binding.editTextTextPersonName.text.toString().trim().equals(sharedPreferences.username)
                    && binding.editTextTextPassword.text.toString().trim().equals(sharedPreferences.password)) {
                    sharedPreferences.login=true
                    startActivity(Intent(this,HomePageActivity::class.java))
                } else {
                    Toast.makeText(this,"Username/Password salah",Toast.LENGTH_SHORT).show()
                }
            }
        }
        binding.register.setOnClickListener {
            if (binding.editTextTextPersonNameRegister.text.isNotEmpty() && binding.editTextTextPasswordRegister.text.isNotEmpty()) {
                sharedPreferences.username=binding.editTextTextPersonNameRegister.text.toString().trim()
                sharedPreferences.password=binding.editTextTextPasswordRegister.text.toString().trim()
                Toast.makeText(this,"Register sukses",Toast.LENGTH_SHORT).show()
                binding.editTextTextPasswordRegister.setText("")
                binding.editTextTextPersonNameRegister.setText("")
            } else {
                Toast.makeText(this,"tidak boleh kosong",Toast.LENGTH_SHORT).show()
            }
        }
    }
}