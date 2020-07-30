package com.mhst.padc_movie_app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.chip.Chip
import com.mhst.padc_movie_app.R
import com.mhst.padc_movie_app.data.vos.GenreVo
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

   private val genres = listOf(GenreVo(1,"friction"),
        GenreVo(2,"thriller"),GenreVo(3, "mystery"),
        GenreVo(4,"romance"))

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

        bindDummyChips()

    }
}