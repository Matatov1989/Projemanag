package com.example.projemanag

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView

class IntroActivity : AppCompatActivity() {

    private lateinit var btnSignInIntro: Button
    private lateinit var btnSignUpIntro: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        initView()

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }

    private fun initView() {
        btnSignInIntro = findViewById(R.id.btnSignInIntro)
        btnSignUpIntro = findViewById(R.id.btnSignUpIntro)
    }
}