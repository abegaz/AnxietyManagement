package ung.csci.a3300.anxietymanagement.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_anxiety_main.*
import ung.csci.a3300.anxietymanagement.R
import kotlinx.android.synthetic.main.activity_games.*

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class anxiety : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_anxiety_main)
        val games_button = findViewById<ImageButton>(R.id.user_games)
        val food_button = findViewById<ImageButton>(R.id.user_food)
        val breathing_button = findViewById<ImageButton>(R.id.user_breathing)
        val music_button = findViewById<ImageButton>(R.id.user_music)
        var clickListener = View.OnClickListener {view ->
            when (view.getId()) {
                R.id.user_games -> openGamesActivity()
                R.id.user_food -> openFoodActivity()
                R.id.user_breathing -> openBreathingActivity()
                R.id.user_music -> openMusicActivity()


            }
        }
        games_button.setOnClickListener(clickListener)
        food_button.setOnClickListener(clickListener)
        breathing_button.setOnClickListener(clickListener)
        music_button.setOnClickListener(clickListener)
    }
    fun openGamesActivity(){
        val intent = Intent(this@anxiety,games::class.java)
        finish()
        startActivity(intent)
    }
    fun openFoodActivity(){
        val intent = Intent(this@anxiety,food::class.java)
        finish()
        startActivity(intent)
    }
    fun openBreathingActivity(){
        val intent = Intent(this@anxiety,breathingExercises::class.java)
        finish()
        startActivity(intent)
    }
    fun openMusicActivity(){
        val intent = Intent(this@anxiety,music::class.java)
        finish()
        startActivity(intent)
    }
    override fun onBackPressed() {
        finish()
        val intent = Intent(this@anxiety, MainActivity::class.java)
        startActivity(intent)
    }
}

