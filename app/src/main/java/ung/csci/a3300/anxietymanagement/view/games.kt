package ung.csci.a3300.anxietymanagement.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import ung.csci.a3300.anxietymanagement.R
import kotlinx.android.synthetic.main.activity_games.*

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class games : AppCompatActivity() {

    var games = arrayOf("Runescape","World of Warcraft", "Counter Strike: Global Offensive")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_games)
        val game_page_select = findViewById<Button>(R.id.nextGame_button)
        val game_display = findViewById<TextView>(R.id.games_showgame_text)
        var clickListener = View.OnClickListener {view ->
            when (view.getId()) {
                R.id.nextGame_button -> pickGame()
            }
        }
        game_page_select.setOnClickListener(clickListener)
        pickGame()
    }

    fun pickGame(){
        var game_index = ((Math.random()* games.size)).toInt()
        games_showgame_text.text = games[game_index]
    }

    fun openMainActivity(){
        val intent = Intent(this@games,MainActivity::class.java)
        finish()
        startActivity(intent)
    }
    override fun onBackPressed() {
        finish()
        val intent = Intent(this@games, anxiety::class.java)
        startActivity(intent)
    }

}

