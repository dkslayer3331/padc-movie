package com.mhst.padc_movie_app.activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import androidx.core.text.HtmlCompat
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.mhst.padc_movie_app.R
import com.mhst.padc_movie_app.adapters.ActorAdapter
import com.mhst.padc_movie_app.adapters.GenrePagerAdapter
import com.mhst.padc_movie_app.adapters.MovieAdapter
import com.mhst.padc_movie_app.adapters.SliderAdapter
import com.mhst.padc_movie_app.data.vos.GenreVo
import com.mhst.padc_movie_app.data.vos.MovieVO
import com.mhst.padc_movie_app.data.vos.PersonVO
import com.mhst.padc_movie_app.mvp.presenter.MainPresenter
import com.mhst.padc_movie_app.mvp.presenter.MainPresenterImpl
import com.mhst.padc_movie_app.mvp.view.MainView
import com.mhst.padc_movie_app.utils.sliderUrlList
import com.smarteist.autoimageslider.SliderAnimations
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),MainView {

    lateinit var adapter: SliderAdapter

    lateinit var genrePagerAdapter: GenrePagerAdapter

    lateinit var movieAdapter : MovieAdapter

    lateinit var mPresenter: MainPresenter

    lateinit var actorAdapter: ActorAdapter

    private fun setupMovieAdapter(){
        movieAdapter = MovieAdapter(mPresenter)
        rvPopularMovies.layoutManager = LinearLayoutManager(this).apply {
            orientation = LinearLayoutManager.HORIZONTAL
        }
        rvPopularMovies.adapter = movieAdapter
    }

    private fun setupActorAdapter(){
        actorAdapter = ActorAdapter()
        rvPerson.layoutManager = LinearLayoutManager(this).apply {
            orientation = LinearLayoutManager.HORIZONTAL
        }
        rvPerson.adapter = actorAdapter
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setupWithTabLayout(genres : List<GenreVo>){
        tabLayout.removeAllTabs()
        for(genre in genres){
            tabLayout.addTab(tabLayout.newTab().setText(genre.name))
        }
        genrePagerAdapter = GenrePagerAdapter(supportFragmentManager,genres)
        genreViewPager.adapter = genrePagerAdapter
        genreViewPager.currentItem = 0

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {}

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabSelected(tab: TabLayout.Tab?) {
                genreViewPager.currentItem = tab!!.position
            }

        })


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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpPresenter()

        setupMovieAdapter()

        setupActorAdapter()

        tvSeeMore.text =HtmlCompat.fromHtml(getString(R.string.see_more),HtmlCompat.FROM_HTML_MODE_LEGACY)

        setupSlider()

        mPresenter.onUiReady(this)

       // setupTabLayout()
    }

//    fun setupSwipeRefresh(){
////        swipeRefreshLayout.setOnRefreshListener {
////            mPresenter.onSwipeRefresh(this)
////        }
//    }

    override fun displayPopularMovies(movies: List<MovieVO>) {
        movieAdapter.setNewData(movies.toMutableList())
    }

    override fun displayActors(actorList: List<PersonVO>) {
        val actorlist = actorList
        actorAdapter.setNewData(actorList.toMutableList())
    }

    override fun navigateToMovieDetails(movieId: Int) {
        startActivity(DetailActivity.onNewIntent(this,movieId))
    }

    override fun enableSwipeRefresh() {
        //swipeRefreshLayout.isRefreshing = true
    }

    override fun disableSwipeRefresh() {
        //swipeRefreshLayout.isRefreshing = false
    }

    override fun displayGenreList(genres: List<GenreVo>) {
        setupWithTabLayout(genres)
    }
}