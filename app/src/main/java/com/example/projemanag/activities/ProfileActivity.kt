package com.example.projemanag.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.Toolbar;
import com.example.projemanag.R

class ProfileActivity : AppCompatActivity() {

    private lateinit var toolbarPprofileActivity: Toolbar
    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etMobile: EditText
    private lateinit var btnUpdate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        initView()
        setupActionBar()

    }

    private fun initView() {
        toolbarPprofileActivity = findViewById(R.id.toolbarPprofileActivity)
        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        etMobile = findViewById(R.id.etMobile)
        btnUpdate = findViewById(R.id.btnUpdate)
    }

    private fun setupActionBar() {
        setSupportActionBar(toolbarPprofileActivity)
        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.baseline_arrow_back_white)
            actionBar.title = resources.getString(R.string.my_profile)
        }

        toolbarPprofileActivity.setNavigationOnClickListener { onBackPressed() }


    }
}