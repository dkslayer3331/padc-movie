package com.mhst.padc_movie_app.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mhst.padc_movie_app.data.vos.GenreVo
import com.mhst.padc_movie_app.fragments.GenreListFragment

/**
 * Created by Moe Htet on 29,July,2020
 */
class GenrePagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

//    var list : MutableList<GenreVo>? = null
//
//    fun setGenreList(genreList : MutableList<GenreVo>){
//        list = genreList
//    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = GenreListFragment.newInstance()
        fragment.arguments = Bundle().apply {
            putInt(GenreListFragment.GENRE_ID_KEY, position)
        }
        return fragment
    }


}