package com.example.projemanag.firebase

import android.app.Activity
import android.util.Log
import com.example.projemanag.activities.MainActivity
import com.example.projemanag.activities.SignInActivity
import com.example.projemanag.activities.SignUpActivity
import com.example.projemanag.models.User
import com.example.projemanag.utils.Constants
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions

class FireStoreClass {

    private val mFireStore = FirebaseFirestore.getInstance()

    fun registerUser(activity: SignUpActivity, userInfo: User) {
        mFireStore.collection(Constants.USERS)
            .document(getCurrentUserId())
            .set(userInfo, SetOptions.merge())
            .addOnSuccessListener {
                activity.userRegisteredSuccess()
            }
            .addOnFailureListener { e->
                Log.e("Firebase singUp", "Error writing document to firestore ${e.message}", e)
            }
    }

    fun signInUser(activity: Activity) {
        mFireStore.collection(Constants.USERS)
            .document(getCurrentUserId())
            .get()
            .addOnSuccessListener { document ->
                val loggedInUser = document.toObject(User::class.java)

                loggedInUser?.let {
                    when (activity) {
                        is SignInActivity -> {
                            activity.signInSuccess(it)
                        }
                        is MainActivity -> {
                            activity.updateNavigationUserDetails(it)
                        }
                    }
                }

            }
            .addOnFailureListener { e ->
                when (activity) {
                    is SignInActivity -> {
                        activity.hideProgressDialog()
                    }
                    is MainActivity -> {
                        activity.hideProgressDialog()
                    }
                }
                Log.e("Firebase signIn", "Error getting document to firestore ${e.message}", e)
            }
    }

    fun getCurrentUserId(): String = FirebaseAuth.getInstance().currentUser?.uid ?: ""
}
