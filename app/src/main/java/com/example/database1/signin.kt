package com.example.database1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class signin : AppCompatActivity() {
    lateinit var databaseReference: DatabaseReference
    companion object{
        const val KEY1= "com.example.database1.signin.email1"
        const val KEY2= "com.example.database1.signin.Name1"
        const val KEY3= "com.example.database1.signin.userID1"


    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        val Singinbtn = findViewById<Button>(R.id.signIN)
        val userName = findViewById<EditText>(R.id.userNameEdittext)



        Singinbtn.setOnClickListener{
            //take ref till node "Users

            val  UniqueId  = userName.text.toString()

            if(UniqueId.isNotEmpty())
            {
                readData(UniqueId)

            }else{
               Toast.makeText(this,"Enter User Id",Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun readData(uniqueId: String) {

        databaseReference = FirebaseDatabase.getInstance().getReference("Users")

        databaseReference.child(uniqueId).get().addOnSuccessListener {

            if(it.exists()){
                //open Welcome users

                val email1 = it.child("email").value
                val Name1 = it.child("name").value
                val usreId1 = it.child("user").value

                val intentWelcome = Intent(this,WelcomeActivity::class.java)
                intentWelcome.putExtra(KEY1,email1.toString())
                intentWelcome.putExtra(KEY2,Name1.toString())
                intentWelcome.putExtra(KEY3,usreId1.toString())
                startActivity(intentWelcome)

            }else{
                Toast.makeText(this,"User Does Not Exist",Toast.LENGTH_SHORT).show()
            }

        }.addOnFailureListener {
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
        }
    }
}