package com.example.projemanag.activities

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.widget.TextView
import com.example.projemanag.R
import com.example.projemanag.firebase.FireStoreClass

class SplashActivity : AppCompatActivity() {

    private lateinit var tvAppName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        tvAppName = findViewById(R.id.tvAppName)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        val typeFace: Typeface = Typeface.createFromAsset(assets, "carbon bl.ttf")
        tvAppName.typeface = typeFace


        Handler().postDelayed({
            var currentUserId = FireStoreClass().getCurrentUserId()
            if (currentUserId.isNotEmpty()) {
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                startActivity(Intent(this, IntroActivity::class.java))
            }

            finish()
        }, 2500)
    }
}
