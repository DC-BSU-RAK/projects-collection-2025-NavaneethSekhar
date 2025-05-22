package com.example.pawz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pawz.databinding.ActivityRecommendationsBinding

class RecommendationsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecommendationsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecommendationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val petType = intent.getStringExtra("petType")
        val username = intent.getStringExtra("username")

        binding.title.text = "$petType Care Tips for $username"

        when (petType) {
            "Dog" -> {
                binding.feed.text = "Feed: High-protein dog food 2x daily"
                binding.groom.text = "Groom: Brush every week, bathe monthly"
                binding.health.text = "Health: Regular walks, flea meds, vet yearly"
                binding.petImage.setImageResource(R.drawable.dog_icon)
            }
            "Cat" -> {
                binding.feed.text = "Feed: Wet + dry food mix, clean water"
                binding.groom.text = "Groom: Brush 2-3x a week"
                binding.health.text = "Health: Vaccines, flea treatment, vet check-ups"
                binding.petImage.setImageResource(R.drawable.cat_icon)
            }
        }

        binding.backButton.setOnClickListener {
            finish()
        }
    }
}
