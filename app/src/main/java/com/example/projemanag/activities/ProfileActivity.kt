package com.example.projemanag.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.Toolbar;
import com.bumptech.glide.Glide
import com.example.projemanag.R
import com.example.projemanag.firebase.FireStoreClass
import com.example.projemanag.models.User
import de.hdodenhof.circleimageview.CircleImageView

class ProfileActivity : AppCompatActivity() {

    private lateinit var toolbarPprofileActivity: Toolbar
    private lateinit var ivUserImage: CircleImageView
    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etMobile: EditText
    private lateinit var btnUpdate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        initView()
        setupActionBar()

        FireStoreClass().loadUserData(this)

    }

    private fun initView() {
        toolbarPprofileActivity = findViewById(R.id.toolbarPprofileActivity)
        ivUserImage = findViewById(R.id.ivUserImage)
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

    fun setUserDataInUI(user: User) {
        Glide
            .with(this@ProfileActivity)
            .load(user.image)
            .centerCrop()
            .placeholder(R.drawable.ic_user_place_holder)
            .into(ivUserImage)

        etName.setText(user.name)
        etEmail.setText(user.email)
        etMobile.setText(if (user.mobile != 0L) user.mobile.toString() else "")

    }
}