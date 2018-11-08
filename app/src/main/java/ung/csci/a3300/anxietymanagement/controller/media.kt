package ung.csci.a3300.anxietymanagement.controller
import android.media.MediaPlayer
interface Factory<T> {
    fun create(): T
}
class media {
    companion object mediaplayer{
        fun create():media = media()
        val player = MediaPlayer()
    }
}
