package com.mhst.padc_movie_app.activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayoutMediator
import com.mhst.padc_movie_app.R
import com.mhst.padc_movie_app.adapters.GenrePagerAdapter
import com.mhst.padc_movie_app.adapters.MovieAdapter
import com.mhst.padc_movie_app.adapters.SliderAdapter
import com.mhst.padc_movie_app.data.vos.MovieVO
import com.mhst.padc_movie_app.data.vos.PersonVO
import com.mhst.padc_movie_app.mvp.view.MainView
import com.mhst.padc_movie_app.utils.sliderUrlList
import com.smarteist.autoimageslider.SliderAnimations
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),MainView {

    lateinit var adapter: SliderAdapter

    lateinit var genrePagerAdapter: GenrePagerAdapter

    lateinit var movieAdapter : MovieAdapter

    private fun setupMovieAdapter(){
        movieAdapter = MovieAdapter()
        rvPopularMovies.layoutManager = LinearLayoutManager(this).apply {
            orientation = LinearLayoutManager.HORIZONTAL
        }
        rvPopularMovies.adapter = movieAdapter
    }

    private fun setupSlider(){
        adapter = SliderAdapter()
        adapter.setNewData(sliderUrlList)
        posterSlider.apply {
            startAutoCycle()
            setSliderAdapter(adapter)
            setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
            indicatorSelectedColor = Color.YELLOW
        }

    }

    private fun setupTabLayout(){
        TabLayoutMediator(tabLayout,genreViewPager){ tab ,pos ->
            tab.text = "tab ${pos+1}"
        }.attach()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupMovieAdapter()

        genrePagerAdapter = GenrePagerAdapter(this)

        tvSeeMore.text =HtmlCompat.fromHtml(getString(R.string.see_more),HtmlCompat.FROM_HTML_MODE_LEGACY)

        setupSlider()

        setupTabLayout()
    }

    override fun displayPopularMovies(movies: List<MovieVO>) {
        movieAdapter.setNewData(movies.toMutableList())
    }

    override fun displayActors(actorList: List<PersonVO>) {

    }

    override fun navigateToMovieDetails(movieId: Int) {
        startActivity(DetailActivity.onNewIntent(this))
    }

    override fun enableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = true
    }

    override fun disableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = false
    }
}