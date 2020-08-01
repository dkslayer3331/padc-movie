package com.mhst.padc_movie_app.activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.text.HtmlCompat
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mhst.padc_movie_app.R
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
import com.mhst.padc_movie_app.views.viewpods.ActorsRecyclerViewpod
import com.mhst.padc_movie_app.views.viewpods.PopularMoviesViewpod
import com.mhst.padc_movie_app.views.viewpods.TabAndViewPagerViewpod
import com.smarteist.autoimageslider.SliderAnimations
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),MainView {

    lateinit var adapter: SliderAdapter

    lateinit var genrePagerAdapter: GenrePagerAdapter

    lateinit var mPresenter: MainPresenter

    lateinit var viewpagerPagerTabAndPager : TabAndViewPagerViewpod

    lateinit var viewpodActorsRecycler: ActorsRecyclerViewpod

    lateinit var viewpodPopularMovies : PopularMoviesViewpod

    lateinit var movieAdapter: MovieAdapter

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
        mPresenter.initPresenter(this)
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

        viewpagerPagerTabAndPager = vpTabAndPager as TabAndViewPagerViewpod

        viewpodActorsRecycler = vpActorRecycler as ActorsRecyclerViewpod

        viewpodPopularMovies = vpMoviesReclcyer as PopularMoviesViewpod

        setUpPresenter()

        tvSeeMore.text =HtmlCompat.fromHtml(getString(R.string.see_more),HtmlCompat.FROM_HTML_MODE_LEGACY)

        setupSlider()

        mPresenter.onUiReady(this)

    }

    override fun displayPopularMovies(movies: List<MovieVO>) {
       movieAdapter = MovieAdapter(mPresenter)
       viewpodPopularMovies.binData(movieAdapter,movies.toMutableList())
    }

    override fun displayActors(actorList: List<PersonVO>) {
        viewpodActorsRecycler.bindActors(actorList)
    }

    override fun navigateToMovieDetails(movieId: Int) {
        startActivity(DetailActivity.onNewIntent(this,movieId))
    }

    override fun enableSwipeRefresh() {

    }

    override fun disableSwipeRefresh() {

    }

    override fun displayGenreList(genres: List<GenreVo>) {
        genrePagerAdapter = GenrePagerAdapter(this,genres)
        viewpagerPagerTabAndPager.bindData(genrePagerAdapter)
    }
}