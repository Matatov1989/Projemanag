package com.example.projemanag.activities

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import com.example.projemanag.R

class IntroActivity : BaseActivity() {

    private lateinit var btnSignInIntro: Button
    private lateinit var btnSignUpIntro: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        initView()
        initClickListeners()
    }

    private fun initView() {
        btnSignInIntro = findViewById(R.id.btnSignInIntro)
        btnSignUpIntro = findViewById(R.id.btnSignUpIntro)
    }

    private fun initClickListeners() {
        btnSignUpIntro.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        btnSignInIntro.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
        }
    }
}
