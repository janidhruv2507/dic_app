package com.example.dic_login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dic_login.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
       setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()

        binding.loginBtn.setOnClickListener{
            val email = binding.usernameInput.text.toString()
            val pass = binding.passwordInput.text.toString()

            if(email.isNotEmpty() && pass.isNotEmpty())
            {
                firebaseAuth.signInWithEmailAndPassword(email , pass).addOnCompleteListener{
                    if(it.isSuccessful){
                        val intent = Intent(this, pageone::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }else
            {
                Toast.makeText(this, "empty field not allowed", Toast.LENGTH_SHORT).show()
            }

        }




    }
}
