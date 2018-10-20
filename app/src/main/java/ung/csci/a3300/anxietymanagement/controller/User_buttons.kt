package ung.csci.a3300.anxietymanagement.controller

import android.support.v7.app.AppCompatActivity
import ung.csci.a3300.anxietymanagement.R
import android.view.View

class User_buttons : AppCompatActivity()  {
/*
    val meetup_Button = findViewById(R.id.user_meetup) as ImageButton
    meetup_Button.setOnClickListener(View.OnClickListener {  })
    val chat_button = findViewById(R.id.user_chat) as ImageButton
    chat_button.setOnClickListener(View.OnClickListener { btnListener })
    val games_button = findViewById(R.id.user_games) as ImageButton
    games_button.setOnClickListener(btnListener)

    private val btnListener = object : View.OnClickListener {

        override fun onClick(view: View) {
            //do the same stuff or use switch/case and get each button ID and do different

            //stuff depending on the ID
        }

    }
*/


    fun changeView_home(view: View) {
        setContentView(R.layout.activity_main)

    }
    /** Called when the user taps the Send button  */
    fun changeView_food(view: View) {
        view.findViewById<View>(R.id.user_food)
        // Do something in response to button

    }
    fun changeView_meetup(view: View) {
        // Do something in response to button
        setContentView(R.layout.view_meetup)
    }
    fun changeView_games(view: View) {
        // Do something in response to button
        setContentView(R.layout.view_games)
    }
    fun changeView_settings(view: View) {
        // Do something in response to button
        setContentView(R.layout.view_settings)
    }
    fun changeView_chat(view: View) {
        // Do something in response to button
        setContentView(R.layout.view_chat)
    }
    fun changeView_anxiety(view: View) {
        // Do something in response to button
        setContentView(R.layout.view_anxiety_main)
    }
    fun changeView_register(view: View) {
        // Do something in response to button
        setContentView(R.layout.register)
    }
}