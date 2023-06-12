package com.example.Carwashapp

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.Carwashapp.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()


        binding.registermail.inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
        binding.registertelefon.inputType = InputType.TYPE_CLASS_PHONE

        binding.kayitOlbtn.setOnClickListener {
            val name = binding.RegisterAd.text.toString()
            val tell = binding.registertelefon.text.toString()
            val email = binding.registermail.text.toString()
            val pass = binding.registerSifre.text.toString()
            val comfirmpass = binding.registerSifredogrulama.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty() && pass.isNotEmpty() && comfirmpass.isNotEmpty()) {
                if (pass == comfirmpass) {
                    firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                        if (it.isSuccessful) {
                            val intent = Intent(this, LoginActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(this, "Şifre Eşleşmiyor!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Boş alanlara izin verilmez!", Toast.LENGTH_SHORT).show()
            }

        }

    }

}






