package ung.csci.a3300.anxietymanagement.view

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import ung.csci.a3300.anxietymanagement.R
import android.R.raw
import android.widget.*
import android.widget.ListView
import android.widget.ListAdapter
import android.widget.ArrayAdapter
import android.widget.AdapterView
import kotlinx.android.synthetic.main.activity_games.*

class login : AppCompatActivity() {
    public var mainSceneReady = false
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val loginBtn = findViewById<Button>(R.id.login_button)
        val registerBtn = findViewById<Button>(R.id.register_button)

        var clickListener = View.OnClickListener { view ->
            when (view.getId()) {
                R.id.login_button -> openSymptoms()
                R.id.register_button -> openRegister()

            }

        }

        loginBtn.setOnClickListener(clickListener)
        registerBtn.setOnClickListener(clickListener)

    }

    fun openRegister() {
        val intent = Intent(this@login, register::class.java)
        finish()
        startActivity(intent)
    }

    fun openSymptoms() {
        val intent = Intent(this@login, symptoms::class.java)
        finish()
        startActivity(intent)
    }
}
