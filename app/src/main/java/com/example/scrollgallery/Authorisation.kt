package com.example.scrollgallery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.authorisation.*

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.authorisation)
        init()
    }
    private fun init(){
        auth = Firebase.auth

        logInButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            if(email.isNotEmpty() && password.isNotEmpty()){
                logInButton.isClickable = false
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            d("Log in", "signInWithEmail:success")
                            val user = auth.currentUser
                            val intent = Intent(this, profile::class.java)
                            startActivity(intent)
                        } else {
                            // If sign in fails, display a message to the user.
                            d("Log in", "signInWithEmail:failure", task.exception)
                            Toast.makeText(baseContext, "Authentication failed",
                                Toast.LENGTH_SHORT).show()
                            logInButton.isClickable = true
                        }
                    }

            }else{
                Toast.makeText(this,"Please fill in all fields", Toast.LENGTH_LONG).show()
            }
        }
    }
}