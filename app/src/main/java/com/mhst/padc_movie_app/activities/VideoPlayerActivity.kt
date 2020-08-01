package com.mhst.padc_movie_app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mhst.padc_movie_app.R
import com.mhst.padc_movie_app.mvp.view.VideoView

class VideoPlayerActivity : AppCompatActivity(),VideoView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player)
    }

    override fun showVideo(movieId: Int) {

    }
}