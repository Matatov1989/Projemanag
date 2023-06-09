package com.example.projemanag

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.TextView

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
    }
}
