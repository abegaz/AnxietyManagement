package ung.csci.a3300.anxietymanagement.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import ung.csci.a3300.anxietymanagement.R
import kotlinx.android.synthetic.main.activity_games.*

class register : AppCompatActivity() {
    public var mainSceneReady = false;
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)


        val submitBtn = findViewById<Button>(R.id.submitAccount_button)

        var clickListener = View.OnClickListener { view ->
            when (view.getId()) {
                R.id.submitAccount_button -> openSymptoms()

            }

        }

        submitBtn.setOnClickListener(clickListener)

    }




    fun openSymptoms() {
        val intent = Intent(this@register, symptoms::class.java)
        finish()
        startActivity(intent)
    }

    }



