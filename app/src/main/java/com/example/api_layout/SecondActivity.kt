package com.example.api_layout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerSupportFragment
import kotlinx.android.synthetic.main.activity_main.*


class SecondActivity : AppCompatActivity() {

    companion object {
        const val FOOD_Name = "food_passer"
    }


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        initUI()
    }

    private fun initUI() {

        val foodmap: Map<String, String> = mapOf(
                "Indisches Curry" to "9DQ5QaAsCDs",
                "Burger" to "vCXg4tuMpe4",
                "Maultaschen" to "xA5P75X_xGE",
                "Spaghetti" to "Io3osssFJ6o",
                "Minestrone" to "Usp-Rgyn2kc",
                "Steak" to "mdl6CPSifiI"
        )
        val vidId = foodmap[intent.getStringExtra(FOOD_Name)]


        var youtubefragment = supportFragmentManager.findFragmentById(R.id.youtube_fragment)
                as YouTubePlayerSupportFragment

        youtubefragment.initialize("AIzaSyBo2cWBK3_eOdYiKpcNyfp6P4TE4B3nUEw", object : YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(provider: YouTubePlayer.Provider?, player: YouTubePlayer?, wasRestored: Boolean) {
                if (player == null) return
                if (wasRestored)
                    player.play()
                else {
                    player.cueVideo(vidId)
                    player.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT)
                }

            }

            override fun onInitializationFailure(
                    p0: YouTubePlayer.Provider?,
                    p1: YouTubeInitializationResult?
            ) {

            }

        })
    }

}