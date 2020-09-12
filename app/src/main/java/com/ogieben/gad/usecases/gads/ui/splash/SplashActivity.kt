package com.ogieben.gad.usecases.gads.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.ogieben.gad.R
import com.ogieben.gad.usecases.gads.ui.home.HomeActivity


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_splash)
        Handler().postDelayed(
            Runnable
            {
                val intent = Intent(this@SplashActivity, HomeActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(intent)
            }, 1500
        )

    }
}