package com.mhst.padc_movie_app.activities

import android.content.AbstractThreadedSyncAdapter
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.android.material.chip.Chip
import com.google.gson.Gson
import com.mhst.padc_movie_app.R
import com.mhst.padc_movie_app.adapters.CastAdapter
import com.mhst.padc_movie_app.adapters.CrewAdapter
import com.mhst.padc_movie_app.data.vos.GenreVo
import com.mhst.padc_movie_app.data.vos.MovieDetailVO
import com.mhst.padc_movie_app.mvp.presenter.DetailPresenter
import com.mhst.padc_movie_app.mvp.presenter.DetailPresenterImpl
import com.mhst.padc_movie_app.mvp.view.DetailView
import com.mhst.padc_movie_app.utils.next_lvl_url
import com.mhst.padc_movie_app.views.viewpods.LabelAndDescViewpod
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*

class DetailActivity : AppCompatActivity(),DetailView {

   private val genres = listOf(GenreVo(1,"friction"),
        GenreVo(2,"thriller"),GenreVo(3, "mystery"),
        GenreVo(4,"romance"))

    var genreStrList = ""

    lateinit var detailPresenter: DetailPresenter

    lateinit var castAdapter: CastAdapter

    lateinit var crewAdapter: CrewAdapter

//    lateinit var vpTitle : LabelAndDescViewpod
//
//    lateinit var vpType : LabelAndDescViewpod
//
//    lateinit var vpProduction : LabelAndDescViewpod
//
//    lateinit var vpPremiere : LabelAndDescViewpod
//
//    lateinit var vpDesc : LabelAndDescViewpod

    fun setupPresenter(){
        detailPresenter = ViewModelProviders.of(this).get(DetailPresenterImpl::class.java)
        detailPresenter.initPresenter(this)
    }

    fun setupCrewAdapter(){
        crewAdapter = CrewAdapter()
        rvDetailCrew.layoutManager = LinearLayoutManager(this).apply {
            orientation = LinearLayoutManager.HORIZONTAL
        }
        rvDetailCrew.adapter = crewAdapter
    }

    fun setupCastAdapter(){
        castAdapter = CastAdapter()
        rvDetailCasts.layoutManager = LinearLayoutManager(this).apply {
            orientation = LinearLayoutManager.HORIZONTAL
        }
        rvDetailCasts.adapter = castAdapter
    }

   private fun bindGenres(genres : List<GenreVo>){
        for(genre in genres){
            val chip = Chip(this).apply {
                text = genre.name
                genreStrList+=genre.name+" "
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

        setupCastAdapter()

        setupCrewAdapter()

        val movieId = intent.getIntExtra(IE_MOVIE_ID,0)

        Log.d("movieId",movieId.toString())

        detailPresenter.onUiReady(movieId)

    }


    companion object{

        const val IE_MOVIE_ID = "movieId"

        fun onNewIntent(context: Context,movieId : Int) : Intent{
            return Intent(context,DetailActivity::class.java).putExtra(IE_MOVIE_ID,movieId)
        }
    }

    override fun showDetail(movieDetailVO: MovieDetailVO) {
        Glide.with(this).load("$next_lvl_url/${movieDetailVO.backDropPath}").into(ivDetailBackDrop)
        val minutes = movieDetailVO.runTime % 60
        tvReleaseYear.text = movieDetailVO.releaseDate
        tvVotes.text = "${movieDetailVO.voteCount} votes"
        tvAvgVoteCount.text = "${movieDetailVO.voteAverage}"
        tvMovieTitle.text = movieDetailVO.originalTitle
        tvDuration.text = "${movieDetailVO.runTime/60}h ${minutes}min"
        tvDesc.text = movieDetailVO.overview
        castAdapter.setNewData(movieDetailVO.credits.cast.toMutableList())
        crewAdapter.setNewData(movieDetailVO.credits.crew.toMutableList())
        bindGenres(movieDetailVO.genres)
        (vpTitle as LabelAndDescViewpod).binData("Original Title",movieDetailVO.originalTitle)
        (vpType as LabelAndDescViewpod).binData("Type",genreStrList)
        (vpProduction as LabelAndDescViewpod).binData("Production",movieDetailVO.productionCountries[0].name)
        (vpPremire as LabelAndDescViewpod).binData("Premiere",movieDetailVO.releaseDate)
        (vpDesc as LabelAndDescViewpod).binData("Description",movieDetailVO.overview)
    }
}