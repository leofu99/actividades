package com.example.ensayo_int
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import java.util.*
import kotlin.concurrent.timerTask


class SplashActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_splash)

        val timer = Timer()
        timer.schedule(timerTask { goTologinActivity() }, 2000)
    }


    private fun goTologinActivity() {
        val intent = Intent(this,loginActivity::class.java)
        startActivity(intent)
        finish()
    }
    }











