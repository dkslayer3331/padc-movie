package com.mhst.padc_movie_app.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mhst.padc_movie_app.data.vos.MovieVO
import com.mhst.padc_movie_app.fragments.ImageSliderFragment
import com.mhst.padc_movie_app.utils.sliderUrlList

/**
 * Created by Moe Htet on 01,August,2020
 */
class ImageSliderAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    var movies :List<MovieVO> = listOf()

    fun setData(popularMovies : List<MovieVO>){
        movies = popularMovies
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun createFragment(position: Int): Fragment {
        return  ImageSliderFragment.newInstance(movies[position].posterPath,movies[position].id.toInt())
    }
}