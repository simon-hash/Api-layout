package com.example.api_layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerSupportFragment

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var youtubefragment = supportFragmentManager.findFragmentById(R.id.youtube_fragment)
                as YouTubePlayerSupportFragment

        youtubefragment.initialize("AIzaSyBo2cWBK3_eOdYiKpcNyfp6P4TE4B3nUEw",object: YouTubePlayer.OnInitializedListener{
            override fun onInitializationSuccess(provider: YouTubePlayer.Provider?, player: YouTubePlayer?, wasRestored: Boolean) {
                if(player == null) return
                if(wasRestored)
                    player.play()
                else{
                    player.cueVideo("Flxi_47SvD0")
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