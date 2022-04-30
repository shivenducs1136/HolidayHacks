package com.terminalstack.helpu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView

class SplashScreen : AppCompatActivity() {
    var isChecked=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        var appname:TextView=findViewById(R.id.appname)
        var lottie:LottieAnimationView=findViewById(R.id.lottie)

//        lottie.setAnimation("helping.json")
//        lottie.playAnimation()
//        lottie.loop(true)

//        appname.animate().translationY(-1400).setDuration(2700).setStartDelay(0);
//        lottie.animate().translationX(-1400).setDuration(2000).setStartDelay(2900);


        Handler().postDelayed({
            val intent=Intent(this,FirstActivity::class.java)
            startActivity(intent)
            finish()

        },2000)

    }
}