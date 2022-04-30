package com.terminalstack.helpu

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import com.terminalstack.helpu.R.id.verifyProgressBar

class OtpVerification : AppCompatActivity() {
   lateinit var code1:EditText
   lateinit var code2:EditText
   lateinit var code3:EditText
   lateinit var code4:EditText
   lateinit var code5:EditText
   lateinit var code6:EditText
   lateinit var getotpbackend:String
   final lateinit var verifyBtn:Button
  final lateinit var verifyProgressBar:ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp_verification)
         verifyBtn=findViewById(R.id.verifyOtpBtn)

        code1=findViewById(R.id.digit1)
        code2=findViewById(R.id.digit2)
        code3=findViewById(R.id.digit3)
        code4=findViewById(R.id.digit4)
        code5=findViewById(R.id.digit5)
        code6=findViewById(R.id.digit6)

        getotpbackend= intent.getStringExtra("backendotp").toString()
        verifyProgressBar=findViewById(R.id.verifyProgressBar)





        verifyBtn.setOnClickListener {

            if(!code1.text.toString().trim().isEmpty()&& !code2.text.toString().trim().isEmpty()&& !code3.text.toString().trim().isEmpty()&& !code4.text.toString().trim().isEmpty()&& !code5.text.toString().trim().isEmpty()&& !code6.text.toString().trim().isEmpty()){

                var entercodeotp:String =code1.text.toString()+code2.text.toString()+code3.text.toString()+code4.text.toString()+code5.text.toString()+code6.text.toString()
                if(getotpbackend!=null){
                    verifyProgressBar.visibility= View.VISIBLE
                    verifyBtn.visibility=View.INVISIBLE

                    var phoneAuthCredential:PhoneAuthCredential =
                        PhoneAuthProvider.getCredential(getotpbackend,entercodeotp)

                    FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential).addOnCompleteListener { task ->
                        verifyProgressBar.visibility = View.GONE
                        verifyBtn.visibility = View.VISIBLE
                        if (task.isSuccessful) {
                            val intent=Intent(this,MainActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or  Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(intent)
                            finish()
                        }
                    }


                }
                else{
                    Toast.makeText(this, "Please Check Internet Connection", Toast.LENGTH_SHORT).show()
                }
                //Toast.makeText(this, "Otp Verify", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "Please enter all the Digits", Toast.LENGTH_SHORT).show()
            }

        }

        setupOTPInputs()

    }
    private fun setupOTPInputs() {
        code1.requestFocus()
        code1.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(!s.toString().trim().isEmpty()){
                    code2.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }


        })
        code2.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(!s.toString().trim().isEmpty()){
                    code3.requestFocus()
                }
                else if(s.toString().trim().isEmpty()){
                    code1.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }


        })
        code3.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(!s.toString().trim().isEmpty()){
                    code4.requestFocus()
                }
                else if(s.toString().trim().isEmpty()){
                    code2.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }


        })
        code4.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(!s.toString().trim().isEmpty()){
                    code5.requestFocus()
                }
                else if(s.toString().trim().isEmpty()){
                    code3.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }


        })
        code5.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(!s.toString().trim().isEmpty()){
                    code6.requestFocus()
                }
                else if(s.toString().trim().isEmpty())
                {
                    code4.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }


        })
        code6.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                if(s.toString().trim().isEmpty())
                {
                    code5.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }


        })


    }

}