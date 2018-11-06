package ung.csci.a3300.anxietymanagement.view

import android.content.Intent
import android.content.res.AssetFileDescriptor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageButton
import ung.csci.a3300.anxietymanagement.R
import android.media.MediaPlayer
import android.util.Base64
import android.widget.Button
import android.widget.Toast
import ung.csci.a3300.anxietymanagement.controller.media
import java.io.IOException
import java.util.*


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class music : AppCompatActivity() {

    var songPlaying = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music)
        val song1_button = findViewById<Button>(R.id.song1_button)
        val song2_button = findViewById<Button>(R.id.song2_button)
        val song3_button = findViewById<Button>(R.id.song3_button)
        val song4_button = findViewById<Button>(R.id.song4_button)

        var clickListener = View.OnClickListener {view ->
            when (view.getId()) {
                R.id.song1_button->song1()
                R.id.song2_button->song2()
                R.id.song3_button->song3()
                R.id.song4_button->song4()

            }
        }
        song1_button.setOnClickListener(clickListener)
        song2_button.setOnClickListener(clickListener)
        song3_button.setOnClickListener(clickListener)
        song4_button.setOnClickListener(clickListener)
    }
    fun song1(){
        val host = baseContext
        val afd = host.getResources().openRawResourceFd(R.raw.exit)
        playSong(afd)
    }
    fun song2(){
        val host = baseContext
        val afd = host.getResources().openRawResourceFd(R.raw.spellbound)
        playSong(afd)
    }
    fun song3(){
        val host = baseContext
        val afd = host.getResources().openRawResourceFd(R.raw.freak)
        playSong(afd)
    }
    fun song4(){
        val host = baseContext
        val afd = host.getResources().openRawResourceFd(R.raw.purple)
        playSong(afd)
    }
    fun playSong(afd:AssetFileDescriptor){
        val fileDescriptor = afd.getFileDescriptor()
        var x = MediaPlayer()
        var player: MediaPlayer? = x as? MediaPlayer

        if (songPlaying==false) {
            songPlaying = true

            try {
                player?.setDataSource(
                    fileDescriptor, afd.getStartOffset(),
                    afd.getLength()
                )
                player?.isLooping = false
                player?.prepare()
                player?.start()

            } catch (ex: IOException) {

            }

            player?.setOnCompletionListener(MediaPlayer.OnCompletionListener() {

                fun onCompletion(mp: MediaPlayer) {
                    songPlaying=false
                    player?.release()
                }


            });
            Toast.makeText(this,"Started playing",Toast.LENGTH_SHORT).show()
        }
        else{
            if(player!=null) {
                songPlaying = false
                player?.stop()
                player?.reset()
                player?.release()
                player = null
                Toast.makeText(this, "Stopped playing", Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onBackPressed() {
        finish()
        val intent = Intent(this@music, anxiety::class.java)
        startActivity(intent)
    }
}
