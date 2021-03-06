package com.mhst.padc_movie_app.activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.text.HtmlCompat
import androidx.lifecycle.ViewModelProviders
import com.mhst.padc_movie_app.R
import com.mhst.padc_movie_app.adapters.*
import com.mhst.padc_movie_app.data.vos.GenreVo
import com.mhst.padc_movie_app.data.vos.MovieVO
import com.mhst.padc_movie_app.data.vos.PersonVO
import com.mhst.padc_movie_app.mvp.presenter.MainPresenter
import com.mhst.padc_movie_app.mvp.presenter.MainPresenterImpl
import com.mhst.padc_movie_app.mvp.view.MainView
import com.mhst.padc_movie_app.views.viewpods.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),MainView {

    lateinit var adapter: SliderAdapter

    lateinit var genrePagerAdapter: GenrePagerAdapter

    lateinit var mPresenter: MainPresenter

    lateinit var showcaseAdapter: ShowcaseAdapter

    lateinit var viewpagerPagerTabAndPager : TabAndViewPagerViewpod

    lateinit var viewpodActorsRecycler: ActorsRecyclerViewpod

    lateinit var viewpodPopularMovies : PopularMoviesViewpod

    lateinit var viewpodShowcase : ShowCaseViewpod

    lateinit var viewpodSlider : ImageSliderViewpod

    lateinit var movieAdapter: MovieAdapter

    lateinit var imageSliderAdapter: ImageSliderAdapter

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setupSlider(movies : List<MovieVO>){
        imageSliderAdapter = ImageSliderAdapter(this)
        imageSliderAdapter.setData(movies.take(5))
        viewpodSlider.binData(imageSliderAdapter)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewpodSlider = vpSlider as ImageSliderViewpod

        viewpagerPagerTabAndPager = vpTabAndPager as TabAndViewPagerViewpod

        viewpodActorsRecycler = vpActorRecycler as ActorsRecyclerViewpod

        viewpodPopularMovies = vpMoviesReclcyer as PopularMoviesViewpod

        viewpodShowcase = vpShowcase as ShowCaseViewpod

        setUpPresenter()

        tvSeeMore.text = HtmlCompat.fromHtml(getString(R.string.see_more),HtmlCompat.FROM_HTML_MODE_LEGACY)

        mPresenter.onUiReady(this)

        swipeRefreshLayout.setOnRefreshListener {
            mPresenter.onSwipeRefresh(this)
        }

    }

    override fun displayPopularMovies(movies: List<MovieVO>) {
        setupSlider(movies)
       movieAdapter = MovieAdapter(mPresenter)
        showcaseAdapter = ShowcaseAdapter(mPresenter)
       viewpodPopularMovies.binData(movieAdapter,movies.toMutableList())
       viewpodShowcase.bindData(showcaseAdapter,movies.reversed().toMutableList())
    }

    override fun displayActors(actorList: List<PersonVO>) {
        viewpodActorsRecycler.bindActors(actorList,mPresenter)
    }

    override fun navigateToMovieDetails(movieId: Int) {
        startActivity(DetailActivity.onNewIntent(this,movieId))
    }

    override fun enableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = true
    }

    override fun disableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = false
    }

    override fun displayGenreList(genres: List<GenreVo>) {
        genrePagerAdapter = GenrePagerAdapter(this,genres)
        viewpagerPagerTabAndPager.bindData(genrePagerAdapter)
    }

    override fun navigateVideo(movieId: Int) {
        Log.d("me also","get called")
        startActivity(VideoPlayerActivity.onNewIntent(this,movieId))
    }
}