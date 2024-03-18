package com.example.jobfinder

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
// Done by Anai Joshy
class HomescreenActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_homescreen)
            val logoutIcon = findViewById<ImageView>(R.id.logoutIcon)
            logoutIcon.setOnClickListener {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
            val viewListingCard = findViewById<androidx.cardview.widget.CardView>(R.id.viewListing)
            viewListingCard.setOnClickListener {
                val intent = Intent(this, CandidateActivity::class.java)
                startActivity(intent)
            }
    }
}