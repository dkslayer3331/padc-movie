package com.mhst.padc_movie_app.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.mhst.padc_movie_app.adapters.MovieAdapter
import com.mhst.padc_movie_app.data.vos.MovieVO
import kotlinx.android.synthetic.main.viwepod_popular_movies_recycler.view.*

/**
 * Created by Moe Htet on 01,August,2020
 */
class PopularMoviesViewpod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    fun binData(movieAdapter: MovieAdapter,movies : MutableList<MovieVO>){
        rvPopularMovies.adapter = movieAdapter
        movieAdapter.setNewData(movies)
    }

}