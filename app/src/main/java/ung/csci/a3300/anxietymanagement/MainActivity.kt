package ung.csci.a3300.anxietymanagement

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.view.View
import android.widget.ImageButton
import ung.csci.a3300.anxietymanagement.controller.User_buttons


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val meetup_button = findViewById<ImageButton>(R.id.user_meetup)
        val chat_button = findViewById<ImageButton>(R.id.user_chat)
        val anxiety_button = findViewById<ImageButton>(R.id.user_anxiety)
        val food_button = findViewById<ImageButton>(R.id.user_food)
        val games_button = findViewById<ImageButton>(R.id.user_games)
        val settings_button = findViewById<ImageButton>(R.id.user_setting)
        val back_button = findViewById<ImageButton>(R.id.user_backButton)
//        val login_button = findViewById<ImageButton>(R.id.login_button)
//        val register_button = findViewById<ImageButton>(R.id.register_button)

        var clickListener = View.OnClickListener {view ->

            when (view.getId()) {
                R.id.user_anxiety -> setContentView(R.layout.view_anxiety_main)
                R.id.user_setting -> setContentView(R.layout.view_settings)
                R.id.user_meetup -> setContentView(R.layout.view_meetup)
                R.id.user_games -> setContentView(R.layout.view_games)
                R.id.user_chat -> setContentView(R.layout.view_chat)
                R.id.user_food -> setContentView(R.layout.view_food)
                R.id.user_backButton -> setContentView(R.layout.activity_main)
                R.id.register_button -> setContentView(R.layout.register)
            }
        }
        meetup_button.setOnClickListener(clickListener)
        chat_button.setOnClickListener(clickListener)
        anxiety_button.setOnClickListener(clickListener)
        food_button.setOnClickListener(clickListener)
        games_button.setOnClickListener(clickListener)
        settings_button.setOnClickListener(clickListener)
        back_button.setOnClickListener(clickListener)
//        login_button.setOnClickListener(clickListener)
//        register_button.setOnClickListener(clickListener)
    }
    override fun onStart(){
        super.onStart()
//        val buttons = User_buttons()
//        buttons.runButtons()

    }
}
