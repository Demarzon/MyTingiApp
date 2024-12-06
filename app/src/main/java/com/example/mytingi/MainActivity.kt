package com.example.mytingi

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        val button = findViewById<Button>(R.id.login1)
        val button2 = findViewById<Button>(R.id.register)
        val emailEditText = findViewById<EditText>(R.id.emailEdit)
        val passwordEditText = findViewById<EditText>(R.id.passwordEdit)

        firebaseAuth = FirebaseAuth.getInstance()

        button.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
            else {
                // Perform login logic
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener{
                    if(it.isSuccessful){
                        val intent = Intent(this, MainActivity2::class.java)
                        startActivity(intent)
                        Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()

                }else{
                    Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }                }

            }
        }

        button2.setOnClickListener {
            val intent = Intent(this, register::class.java)
            startActivity(intent)
        }
    }
}


