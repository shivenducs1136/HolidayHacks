package com.terminalstack.helpu

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import android.widget.*
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.PhoneAuthProvider.*
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.util.concurrent.TimeUnit

const val RC_SIGN_IN=120
class LoginActivity : AppCompatActivity() {
    lateinit var google_btn:Button
    lateinit var GetOtpBtn:Button
    private lateinit var signUpTv:TextView
    lateinit var userNumber:EditText
    lateinit var progressBar:ProgressBar
    private lateinit var auth:FirebaseAuth
    private lateinit var gSignInClient:GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        progressBar=findViewById(R.id.mobileProgressBar)
        auth= FirebaseAuth.getInstance()
        userNumber=findViewById(R.id.mobileNumber)
        signUpTv=findViewById(R.id.SignUpTv)
        GetOtpBtn=findViewById(R.id.GetOtpBtn)
        google_btn=findViewById(R.id.googleSignInBtn)



        auth = Firebase.auth

        google_btn.setOnClickListener {
            signIn()
        }







        GetOtpBtn.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                if(!userNumber.text.toString().trim().isEmpty()) {
                    if ((userNumber.text.toString().trim()).length==10) {
                        progressBar.visibility = View.VISIBLE
                        GetOtpBtn.visibility = View.INVISIBLE
                        otp(userNumber.toString())


                    }
                    else{
                        Toast.makeText(
                            this@LoginActivity,
                            "Enter Correct 10 Digit Mobile Number",
                            Toast.LENGTH_SHORT
                        ).show()
                        return
                    }
                }

                else{
                    Toast.makeText(
                        this@LoginActivity,
                        "Enter Mobile Number",
                        Toast.LENGTH_SHORT
                    ).show()
                    return
                }


                //Your code here
            }})

        signUpTv.setOnClickListener {
            val intent=Intent(this@LoginActivity,RegisterActivity::class.java)
            startActivity(intent)
        }



    }


    private fun otp(number:String)
    {
        var num: String =userNumber.text.toString()

        PhoneAuthProvider.getInstance().verifyPhoneNumber("+91"+num,60,TimeUnit.SECONDS,this,object:PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
            override fun onVerificationCompleted(p0: PhoneAuthCredential) {
                progressBar.visibility = View.GONE
                GetOtpBtn.visibility = View.VISIBLE
            }

            override fun onVerificationFailed(e: FirebaseException) {
                progressBar.visibility = View.GONE
                GetOtpBtn.visibility = View.VISIBLE
                Toast.makeText(this@LoginActivity,e.message,Toast.LENGTH_SHORT).show()
            }

            override fun onCodeSent(backendotp: String, forcedResendingToken:ForceResendingToken) {
                progressBar.visibility = View.GONE
                GetOtpBtn.visibility = View.VISIBLE
                var intent=Intent(this@LoginActivity,OtpVerification::class.java)
                intent.putExtra("mobile",userNumber.text.toString())
                intent.putExtra("backendotp",backendotp)
                startActivity(intent)

            }
        }

        )

    }
    override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
    }

    private fun signIn(){
        val gso=GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        gSignInClient=GoogleSignIn.getClient(this,gso)

        val signInIntent=gSignInClient.signInIntent
        startActivityForResult(signInIntent,RC_SIGN_IN)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            val exception=task.exception
            if(task.isSuccessful){
                try {
                    // Google Sign In was successful, authenticate with Firebase
                    val account = task.getResult(ApiException::class.java)!!
                    Log.e(TAG, "firebaseAuthWithGoogle:" + account.id)
                    firebaseAuthWithGoogle(account.idToken!!)
                } catch (e: ApiException) {
                    // Google Sign In failed, update UI appropriately
                    Log.e(TAG, "Google sign in failed", e)
                }

            }
            else{
                Log.e("SignInActivity",exception.toString())

            }

        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.e(TAG, "signInWithCredential:success")
                  val intent=Intent(this@LoginActivity,MainActivity::class.java)
                    startActivity(intent)
                    finish()

                } else {
                    // If sign in fails, display a message to the user.
                    Log.e(TAG, "signInWithCredential:failure", task.exception)

                }
            }
    }







}


