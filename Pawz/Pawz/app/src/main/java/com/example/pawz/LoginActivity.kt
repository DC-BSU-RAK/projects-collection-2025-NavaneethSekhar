package com.example.pawz

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.pawz.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showWelcomePopup()

        binding.loginButton.setOnClickListener {
            val username = binding.usernameInput.text.toString()
            if (username.isNotBlank()) {
                val intent = Intent(this, PetTypeActivity::class.java)
                intent.putExtra("username", username)
                startActivity(intent)
            } else {
                binding.usernameInput.error = "Please enter your name"
            }
        }
    }

    private fun showWelcomePopup() {
        AlertDialog.Builder(this)
            .setTitle("Welcome to Pawz 🐾")
            .setMessage("We can give you tips and recommendations on how to better help your pets. Please log in to continue.")
            .setPositiveButton("OK", null)
            .show()
    }
}
