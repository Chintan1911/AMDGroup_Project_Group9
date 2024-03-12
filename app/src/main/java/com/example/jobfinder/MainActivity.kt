package com.example.jobfinder

import android.content.Intent
import android.os.Bundle

import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class  MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ivFab: ImageView = findViewById(R.id.ivFab)

        // Set OnClickListener for ivFab
        ivFab.setOnClickListener {
            // Start CandidateActivity when ivFab is clicked
            val intent = Intent(this@MainActivity, CandidateActivity::class.java)
            startActivity(intent)
        }
    }
}
