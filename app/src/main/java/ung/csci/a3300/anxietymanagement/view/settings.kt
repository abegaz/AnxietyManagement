package ung.csci.a3300.anxietymanagement.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageButton
import ung.csci.a3300.anxietymanagement.R
import kotlinx.android.synthetic.main.activity_games.*

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class settings : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_settings)
        val back_button = findViewById<ImageButton>(R.id.user_setting_backButton)
        var clickListener = View.OnClickListener {view ->
            when (view.getId()) {
                R.id.user_setting_backButton -> openMainActivity()
            }
        }
        back_button.setOnClickListener(clickListener)
    }
    fun openMainActivity(){
        val intent = Intent(this@settings,MainActivity::class.java)
        finish()
        startActivity(intent)
    }
}
