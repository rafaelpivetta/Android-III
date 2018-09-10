package com.exercicioiesb.casa.exerciciofinal.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.Window
import android.view.WindowManager
import com.exercicioiesb.casa.exerciciofinal.R

class SplashScreenActivity : AppCompatActivity() {
    private val splashInterval = 3500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.splash_screen)

        Handler().postDelayed(object : Runnable {

            override fun run() {
                val i = Intent(this@SplashScreenActivity, LoginActivity::class.java)
                startActivity(i)
                this.finish()
            }

            private fun finish() {}
        }, splashInterval.toLong())

    };
}