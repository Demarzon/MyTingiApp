package com.example.mytingi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth

class register : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        firebaseAuth = FirebaseAuth.getInstance()


        val button = findViewById<Button>(R.id.back2login)
        val button2 = findViewById<Button>(R.id.reg1)
        val emailEditText = findViewById<EditText>(R.id.regemail)
        val passwordEditText = findViewById<EditText>(R.id.regpassword)
        val passwordEditText2 = findViewById<EditText>(R.id.regpassword2)

        button2.setOnClickListener{

            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()
            val password2 = passwordEditText2.text.toString().trim()
            if (email.isEmpty() || password.isEmpty() || password2.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
            else if (password != password2) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            }else if (password == password2) {

                firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                    if(it.isSuccessful){
                        Toast.makeText(this, "Register Successful!", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)

                    }else{
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }

                }
            }

        }
        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }








    }
}