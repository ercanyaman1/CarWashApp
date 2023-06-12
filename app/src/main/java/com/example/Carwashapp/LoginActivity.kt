package com.example.Carwashapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.Carwashapp.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        binding.registerButton.setOnClickListener {
            val intent = Intent(this, com.example.Carwashapp.RegisterActivity::class.java)

            startActivity(intent)
        }

        binding.continuebtn.setOnClickListener{
            val email = binding.username.text.toString()
            val pass = binding.password.text.toString()

            if ( email.isNotEmpty() && pass.isNotEmpty() ) {

                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener { task ->

                    if (task.isSuccessful) {
                        val intent = Intent(this, com.example.Carwashapp.Homepage::class.java)
                        startActivity(intent)


                        finish()
                    } else {
                        Toast.makeText(this, task.exception?.message, Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Boş alanlara izin verilmez!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}











