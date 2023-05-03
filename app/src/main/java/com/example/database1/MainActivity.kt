package com.example.database1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    lateinit var database :DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn:Button = findViewById(R.id.btnSup)
        var Name:EditText  = findViewById(R.id.etName)
        var Password:EditText  = findViewById(R.id.etPasw)
        var UserId:EditText  = findViewById(R.id.etId)
        var Mail :EditText = findViewById(R.id.etMail)


      btn.setOnClickListener{

          val name =Name.text.toString()
          val  mail = Mail.text.toString()
          val password = Password.text.toString()
          val userId = UserId.text.toString()

          database = FirebaseDatabase.getInstance().getReference("Users")

          val user = User(name,mail,password,userId)
          database.child(userId).setValue(user).addOnSuccessListener{
              Name.text.clear()
              Password.text.clear()
              Mail.text.clear()
              UserId.text.clear()
              Toast.makeText(this,"User Registered",Toast.LENGTH_SHORT).show()
          }.addOnFailureListener{
              Toast.makeText(this,"fail to  Registered",Toast.LENGTH_SHORT).show()
          }
      }

        val signinte = findViewById<TextView>(R.id.textSignIn)
        signinte.setOnClickListener {

            val i = Intent(this,signin::class.java)
            startActivity(i)
        }
    }
}