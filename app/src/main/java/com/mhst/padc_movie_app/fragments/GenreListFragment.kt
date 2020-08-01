package com.mhst.padc_movie_app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProviders
import com.mhst.padc_movie_app.R
import com.mhst.padc_movie_app.activities.DetailActivity
import com.mhst.padc_movie_app.adapters.MovieAdapter
import com.mhst.padc_movie_app.data.vos.MovieVO
import com.mhst.padc_movie_app.mvp.presenter.GenrePresenter
import com.mhst.padc_movie_app.mvp.presenter.GenrePresenterImpl
import com.mhst.padc_movie_app.mvp.view.GenreListView
import kotlinx.android.synthetic.main.fragment_genre_list.*

/**
 * Created by Moe Htet on 29,July,2020
 */
class GenreListFragment : Fragment(),GenreListView {

    companion object{
         const val GENRE_ID_KEY = "genreId"
        fun newInstance(movieId : Int) : GenreListFragment{
            val bundle = Bundle()
            bundle.putInt(GENRE_ID_KEY,movieId)
            val fragment = GenreListFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    lateinit var movieAdapter: MovieAdapter

    lateinit var mPresenter : GenrePresenter

    private fun setupAdapter(){
        movieAdapter = MovieAdapter(mPresenter)
        rvMoviesByGenre.adapter = movieAdapter
    }

    private fun setupPresenter(){
        mPresenter = ViewModelProviders.of(this).get(GenrePresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_genre_list,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        setupPresenter()

        setupAdapter()

           arguments?.takeIf { it.containsKey(GENRE_ID_KEY) }?.apply{
               print("genre id is ${getInt(GENRE_ID_KEY)}")
           }
    }

    override fun displayMoviesByGenre(movies: List<MovieVO>) {
        movieAdapter.setNewData(movies.toMutableList())
    }

    override fun navigateDetail(movieId: Int) {
        requireActivity().startActivity(DetailActivity.onNewIntent(context!!,movieId))
    }


}