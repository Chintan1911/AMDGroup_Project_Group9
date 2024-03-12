package com.example.jobfinder

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var signInButton: Button
    private lateinit var signUpTextView: TextView
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        emailEditText = findViewById(R.id.email)
        passwordEditText = findViewById(R.id.password)
        signInButton = findViewById(R.id.button)
        signUpTextView = findViewById(R.id.txtSignUp)

        signInButton.setOnClickListener {
            signIn()
        }

        signUpTextView.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegistrationActivity::class.java))
        }
    }
    private fun signIn() {
        val userEmail = emailEditText.text.toString().trim()
        val userPassword = passwordEditText.text.toString().trim()

        if (userEmail.isEmpty()) {
            Toast.makeText(this, "Enter Email Address!", Toast.LENGTH_SHORT).show()
            return
        }

        if (userPassword.isEmpty()) {
            Toast.makeText(this, "Enter Password!", Toast.LENGTH_SHORT).show()
            return
        }

        auth.signInWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                Toast.makeText(this@LoginActivity, "Login Successful", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this@LoginActivity, CandidateActivity::class.java))
                finish()
            } else {
                Toast.makeText(this@LoginActivity, "Login Failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}