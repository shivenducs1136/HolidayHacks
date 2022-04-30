package com.terminalstack.helpu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.content.Intent
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class FirstActivity : AppCompatActivity() {

    val mAuth =Firebase.auth
    override fun onStart() {
        super.onStart()

        val user = mAuth.currentUser

            if(user!=null)
            {
                val mainActivityIntent=Intent(this,MainActivity::class.java)
                startActivity(mainActivityIntent)
                finish()
            }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_activity)
        var loginButton: Button = findViewById(R.id.loginbtn)
        var registerButton: Button=findViewById(R.id.registerbtn)
        loginButton.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val intent=Intent(this@FirstActivity,LoginActivity::class.java)
                startActivity(intent)
                //Your code here
            }})
        registerButton.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                val intent=Intent(this@FirstActivity,RegisterActivity::class.java)
                startActivity(intent)
            }

        })





    }
}