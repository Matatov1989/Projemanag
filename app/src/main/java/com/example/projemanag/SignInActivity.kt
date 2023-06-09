package com.example.projemanag

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.Toolbar;

class SignInActivity : AppCompatActivity() {

    private lateinit var toolbarSignInActivity: Toolbar
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnSignIn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        initView()
        setupActionBar()
    }

    private fun initView() {
        toolbarSignInActivity = findViewById(R.id.toolbarSignInActivity)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnSignIn = findViewById(R.id.btnSignIn)
    }

    private fun setupActionBar() {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setSupportActionBar(toolbarSignInActivity)
        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.baseline_arrow_back_ios_24)
        }

        toolbarSignInActivity.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}