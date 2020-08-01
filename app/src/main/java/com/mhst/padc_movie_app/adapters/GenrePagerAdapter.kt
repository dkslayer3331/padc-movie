package com.mhst.padc_movie_app.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mhst.padc_movie_app.data.vos.GenreVo
import com.mhst.padc_movie_app.fragments.GenreListFragment

/**
 * Created by Moe Htet on 29,July,2020
 */
class GenrePagerAdapter(fragmentManager: FragmentManager,val genres : List<GenreVo>) :
    FragmentStatePagerAdapter(fragmentManager,genres.size) {

    override fun getItem(position: Int): Fragment {
        return GenreListFragment.newInstance(genres[position].id)
    }

    override fun getCount(): Int {
        return genres.size
    }


}