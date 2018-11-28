package ung.csci.a3300.anxietymanagement.view

import android.content.Intent
import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.net.Uri
import android.widget.Button
import android.provider.MediaStore
import android.widget.ImageButton
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.core.Tag
import ung.csci.a3300.anxietymanagement.R
import kotlinx.android.synthetic.main.activity_games.*
import kotlinx.android.synthetic.main.register.*
import ung.csci.a3300.anxietymanagement.Chat.LatestMessagesActivity
import ung.csci.a3300.anxietymanagement.Chat.User
import ung.csci.a3300.anxietymanagement.R.id.password_edittext_register
import java.util.*


class register : AppCompatActivity() {
    companion object {
        val TAG = "RegisterActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)


        val submitBtn = findViewById<Button>(R.id.submitAccount_button)

        var clickListener = View.OnClickListener { view ->
                when (view.getId()) {
                    R.id.submitAccount_button -> openMainActivity()

            }

        }

        submitBtn.setOnClickListener(clickListener)
        performRegister()

    }
    private fun performRegister() {
        val email = email_edittext_register.text.toString()
        val password = password_edittext_register.text.toString()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter text in email/pw", Toast.LENGTH_SHORT).show()
            return
        }

        Log.d(TAG, "Attempting to create user with email: $email")

        // Firebase Authentication to create a user with email and password
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (!it.isSuccessful) return@addOnCompleteListener

                // else if successful
                Log.d(TAG, "Successfully created user with uid: ${it.result!!.user.uid}")

                saveUserToFirebaseDatabase(it.toString())
            }
            .addOnFailureListener{
                Log.d(TAG, "Failed to create user: ${it.message}")
                Toast.makeText(this, "Failed to create user: ${it.message}", Toast.LENGTH_SHORT).show()
            }
    }
    private fun saveUserToFirebaseDatabase(profileImageUrl: String) {
        val uid = FirebaseAuth.getInstance().uid ?: ""
        val ref = FirebaseDatabase.getInstance().getReference("/users/$uid")

        val user = User(uid, username_edittext_register.text.toString(), profileImageUrl)

        ref.setValue(user)
            .addOnSuccessListener {
                Log.d(TAG, "Finally we saved the user to Firebase Database")

                val intent = Intent(this, LatestMessagesActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)

            }
            .addOnFailureListener {
                Log.d(TAG, "Failed to set value to database: ${it.message}")
            }
    }



    fun openMainActivity(){
        val intent = Intent(this@register,MainActivity::class.java)
        finish()
        startActivity(intent)
    }

    }

//TODO This code allows you to just login instead of register each time, since as far as i can tell we dont have such things.
// already_have_account_text_view.setOnClickListener {
//      Log.d(TAG, "Try to show login activity")
//
//      // launch the login activity somehow
//      val intent = Intent(this, LoginActivity::class.java)
//      startActivity(intent)
