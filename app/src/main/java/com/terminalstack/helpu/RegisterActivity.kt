package com.terminalstack.helpu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.auth.FirebaseAuth
import java.lang.Exception

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var fAuth:FirebaseAuth= FirebaseAuth.getInstance()

        var name: EditText=findViewById(R.id.name)
        var age: EditText=findViewById(R.id.age)
        var email:EditText=findViewById(R.id.emailAddress)
        var phoneNumber: EditText=findViewById(R.id.phoneNumber)
        var password: EditText=findViewById(R.id.password)
        var gender:EditText=findViewById(R.id.gender)


        var registerBtn: Button= findViewById(R.id.finalRegistration)

        registerBtn.setOnClickListener {
           var userName:String=name.text.toString()
            var userAge:String=age.text.toString()
            var userEmail:String=email.text.toString()
            var userMobileNumber:String=phoneNumber.text.toString()
            var userPassword:String=password.text.toString()
            var userGender:String=gender.text.toString()

            if(userName.isEmpty()){
                name.error = "Full Name is Required"
                return@setOnClickListener;
            }
            if(userAge.isEmpty()){
                age.error = "Age is Required"
                return@setOnClickListener;
            }
            if(userEmail.isEmpty()){
                email.error = "Email-Address is Required"
                return@setOnClickListener;
            }
            if(userMobileNumber.isEmpty()){
                phoneNumber.error = "Mobile-Number is Required"
                return@setOnClickListener;
            }
            if(userPassword.isEmpty()){
                password.error = "Password is Required"
                return@setOnClickListener;
            }
            if(userGender.isEmpty()){
                gender.error = "Gender is Required"
                return@setOnClickListener;
            }
            Toast.makeText(this,"Data Validated",Toast.LENGTH_SHORT).show()


            fAuth.createUserWithEmailAndPassword(userEmail,userPassword).addOnSuccessListener {
                val intent=Intent(this,MainActivity::class.java)
                startActivity(intent)
                Toast.makeText(this,"Added user Sucessfully",Toast.LENGTH_SHORT).show()
                finish()

            }.addOnFailureListener {
                Toast.makeText(this,"Failed to add User",Toast.LENGTH_LONG).show()
            }

        }

    }
}