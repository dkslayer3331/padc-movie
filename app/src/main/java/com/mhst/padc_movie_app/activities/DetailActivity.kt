package com.mhst.padc_movie_app.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.chip.Chip
import com.google.gson.Gson
import com.mhst.padc_movie_app.R
import com.mhst.padc_movie_app.data.vos.GenreVo
import com.mhst.padc_movie_app.data.vos.MovieDetailVO
import com.mhst.padc_movie_app.mvp.presenter.DetailPresenter
import com.mhst.padc_movie_app.mvp.presenter.DetailPresenterImpl
import com.mhst.padc_movie_app.mvp.view.DetailView
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(),DetailView {

   private val genres = listOf(GenreVo(1,"friction"),
        GenreVo(2,"thriller"),GenreVo(3, "mystery"),
        GenreVo(4,"romance"))

    lateinit var detailPresenter: DetailPresenter

    fun setupPresenter(){
        detailPresenter = ViewModelProviders.of(this).get(DetailPresenterImpl::class.java)
        detailPresenter.initPresenter(this)
    }

   private fun bindDummyChips(){
        for(genre in genres){
            val chip = Chip(this).apply {
                text = genre.name
            }
            rvMovieGenres.addView(chip)
        }
        rvMovieGenres
    }

    private fun bindLabelAndTextViewpods(){

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setupPresenter()

        val movieId = intent.getIntExtra(IE_MOVIE_ID,0)

        detailPresenter.onUiReady(movieId)

        bindDummyChips()

    }


    companion object{

        const val IE_MOVIE_ID = "movieId"

        fun onNewIntent(context: Context,movieId : Int) : Intent{
            return Intent(context,DetailActivity::class.java).putExtra(IE_MOVIE_ID,movieId)
        }
    }

    override fun showDetail(movieDetailVO: MovieDetailVO) {
        Log.d("detailmovie",Gson().toJson(movieDetailVO))
    }
}