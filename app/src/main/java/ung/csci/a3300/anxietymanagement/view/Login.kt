package ung.csci.a3300.anxietymanagement.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import ung.csci.a3300.anxietymanagement.R
import kotlinx.android.synthetic.main.activity_games.*
import kotlinx.android.synthetic.main.register.*
import ung.csci.a3300.anxietymanagement.Chat.LatestMessagesActivity
import ung.csci.a3300.anxietymanagement.Chat.User
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.register.*

class Login: AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContentView(R.layout.login)

    login_button.setOnClickListener {
      performLogin()
    }

    register_button.setOnClickListener{
      openregister()
      //TODO Direct to register activity (Causing Crash upon register button click
    }
  }

  private fun performLogin() {
    val email = editText3.text.toString()
    val password = editText4.text.toString()

    if (email.isEmpty() || password.isEmpty()) {
      Toast.makeText(this, "Please fill out email/pw.", Toast.LENGTH_SHORT).show()
      return
    }

    FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
        .addOnCompleteListener {
          if (!it.isSuccessful) return@addOnCompleteListener

          Log.d("Login", "Successfully logged in: ${it.result!!.user.uid}")

          val intent = Intent(this, LatestMessagesActivity::class.java)
          intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
          startActivity(intent)
        }
        .addOnFailureListener {
          Toast.makeText(this, "Failed to log in: ${it.message}", Toast.LENGTH_SHORT).show()
        }
  }
  fun openregister(){
    val intent = Intent(this@Login,register::class.java)
    finish()
    startActivity(intent)
}
    //TODO ^^^^^^^^^^^CAUSING CRASHES...WHY?
}