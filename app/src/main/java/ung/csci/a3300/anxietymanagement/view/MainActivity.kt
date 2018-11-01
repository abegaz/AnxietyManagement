package ung.csci.a3300.anxietymanagement.view


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.content.Intent
import android.widget.Button
import ung.csci.a3300.anxietymanagement.R

class MainActivity() : AppCompatActivity() {
    public var mainSceneReady = false
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val gamesLayout = View.inflate(this, R.layout.view_games, null)
//        val games_back_button = gamesLayout.findViewById<ImageButton>(R.id.user_games_backButton)
        val meetup_button = findViewById<ImageButton>(R.id.user_meetup)
        val chat_button = findViewById<ImageButton>(R.id.user_chat)
        val anxiety_button = findViewById<ImageButton>(R.id.user_anxiety)
        val food_button = findViewById<ImageButton>(R.id.user_food)
        val games_button = findViewById<ImageButton>(R.id.user_games)
        val settings_button = findViewById<ImageButton>(R.id.user_setting)

//        val login_button = findViewById<ImageButton>(R.id.login_button)
//        val register_button = findViewById<ImageButton>(R.id.register_button)
        var clickListener = View.OnClickListener {view ->
            when (view.getId()) {
                R.id.user_anxiety -> openAnxietyActivity()
                R.id.user_setting -> openSettingsActivity()
                R.id.user_meetup -> openMeetupActivity()
                R.id.user_games -> openGamesActivity()
                R.id.user_chat -> openChatActivity()
                R.id.user_food -> openFoodActivity()
//              R.id.user_games_backButton -> setContentView(R.layout.activity_main)
            }
        }

        meetup_button.setOnClickListener(clickListener)
        chat_button.setOnClickListener(clickListener)
        anxiety_button.setOnClickListener(clickListener)
        food_button.setOnClickListener(clickListener)
        games_button.setOnClickListener(clickListener)
        settings_button.setOnClickListener(clickListener)

//        login_button.setOnClickListener(clickListener)
//        register_button.setOnClickListener(clickListener)
    }
    fun openGamesActivity(){
        val intent = Intent(this@MainActivity,games::class.java)
        finish()
        startActivity(intent)
    }
    fun openFoodActivity(){
        val intent = Intent(this@MainActivity,food::class.java)
        finish()
        startActivity(intent)
    }
    fun openChatActivity(){
        val intent = Intent(this@MainActivity,chat::class.java)
        finish()
        startActivity(intent)
    }
    fun openMeetupActivity(){
        val intent = Intent(this@MainActivity,meetup::class.java)
        finish()
        startActivity(intent)
    }
    fun openSettingsActivity(){
        val intent = Intent(this@MainActivity,settings::class.java)
        finish()
        startActivity(intent)
    }
    fun openAnxietyActivity(){
        val intent = Intent(this@MainActivity,anxiety::class.java)
        finish()
        startActivity(intent)
    }
    override fun onStart(){
        super.onStart()

    }

}
