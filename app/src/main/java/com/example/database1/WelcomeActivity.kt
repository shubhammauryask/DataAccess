package com.example.database1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)


        val name1 = intent.getStringExtra(signin.KEY1)
        val email1 = intent.getStringExtra(signin.KEY2)
        val userId = intent.getStringExtra(signin.KEY3)

        val welcomeText = findViewById<TextView>(R.id.tvWelcome)
        val mailText = findViewById<TextView>(R.id.btnMail)
        val Text = findViewById<TextView>(R.id.btnUserId)

        welcomeText.text = "Welcome $email1"
        mailText.text = "Mail:- $name1"
        Text.text ="idText:- $userId"

    }
}