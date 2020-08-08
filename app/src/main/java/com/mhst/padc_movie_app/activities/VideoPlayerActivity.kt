package com.mhst.padc_movie_app.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.mhst.padc_movie_app.R
import com.mhst.padc_movie_app.mvp.presenter.VideoPresenter
import com.mhst.padc_movie_app.mvp.presenter.VideoPresenterImpl
import com.mhst.padc_movie_app.mvp.view.VideoView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import kotlinx.android.synthetic.main.activity_video_player.*

class VideoPlayerActivity : AppCompatActivity(),VideoView {

    lateinit var mPresenter : VideoPresenter

     var movieId : Int = 0

    private fun setupPresenter(){
        mPresenter = ViewModelProviders.of(this).get(VideoPresenterImpl::class.java)

        mPresenter.initPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player)

        setupPresenter()

        lifecycle.addObserver(playerView)

        movieId = intent.getIntExtra(IE_MOVIE_ID,0)

        mPresenter.onUiReady(movieId)

    }

    override fun showVideo(key: String) {
        playerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener(){
            override fun onReady(youTubePlayer: YouTubePlayer) {
               youTubePlayer.loadVideo(key,0f).apply {

               }
            }
        })
    }


    companion object{
        const val IE_MOVIE_ID = "movieId"
        fun onNewIntent(context: Context, movieId: Int) : Intent{
            val intent = Intent(context,VideoPlayerActivity::class.java)
            intent.putExtra(IE_MOVIE_ID,movieId)
            return intent
        }
    }
}