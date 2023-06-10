package com.example.projemanag.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar;
import com.example.projemanag.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class SignUpActivity : BaseActivity() {

    private lateinit var toolbarSignUpActivity: Toolbar
    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnSignUp: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        initView()
        setupActionBar()
        initClickListeners()
    }

    private fun initView() {
        toolbarSignUpActivity = findViewById(R.id.toolbarSignUpActivity)
        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnSignUp = findViewById(R.id.btnSignUp)
    }

    private fun setupActionBar() {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setSupportActionBar(toolbarSignUpActivity)
        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.baseline_arrow_back_ios_24)
        }
    }

    private fun initClickListeners() {
        toolbarSignUpActivity.setNavigationOnClickListener {
            onBackPressed()
        }

        btnSignUp.setOnClickListener {
            registerUser()
        }
    }

    private fun registerUser() {
        val name: String = etName.text.toString().trim { it <= ' ' }
        val email: String = etEmail.text.toString().trim { it <= ' ' }
        val password: String = etPassword.text.toString().trim { it <= ' ' }

        if (validateForm(name, email, password)) {
            showProgressDialog(resources.getString(R.string.please_wait))

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                hideProgressDialog()
                if (task.isSuccessful) {
                    val firebaseUser: FirebaseUser = task.result!!.user!!
                    val registerEmail = firebaseUser.email!!
                    Toast.makeText(this@SignUpActivity, "$name you have succesfully registered the email address $registerEmail", Toast.LENGTH_SHORT).show()
                    FirebaseAuth.getInstance().signOut()
                    finish()
                } else {
                    Toast.makeText(this@SignUpActivity, "${task.exception!!.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun validateForm(name: String, email: String, password: String): Boolean {
        return when {
            TextUtils.isEmpty(name) -> {
                showErrorSnackBar("Please enter a name")
                false
            }
            TextUtils.isEmpty(email) -> {
                showErrorSnackBar("Please enter a e-mail address")
                false
            }
            TextUtils.isEmpty(password) -> {
                showErrorSnackBar("Please enter a password")
                false
            } else -> {
                true
            }
        }
    }
}
