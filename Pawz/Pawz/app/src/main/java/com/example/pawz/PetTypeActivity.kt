package com.example.pawz

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pawz.databinding.ActivityPetTypeBinding

class PetTypeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPetTypeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPetTypeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra("username")

        binding.selectDogButton.setOnClickListener {
            goToRecommendations("Dog", username)
        }

        binding.selectCatButton.setOnClickListener {
            goToRecommendations("Cat", username)
        }

        binding.backButton.setOnClickListener {
            finish()
        }
    }

    private fun goToRecommendations(petType: String, username: String?) {
        val intent = Intent(this, RecommendationsActivity::class.java)
        intent.putExtra("petType", petType)
        intent.putExtra("username", username)
        startActivity(intent)
    }
}
