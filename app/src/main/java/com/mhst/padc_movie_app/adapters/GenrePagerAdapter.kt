package com.mhst.padc_movie_app.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mhst.padc_movie_app.data.vos.GenreVo
import com.mhst.padc_movie_app.fragments.GenreListFragment

/**
 * Created by Moe Htet on 29,July,2020
 */
class GenrePagerAdapter(fragmentActivity: FragmentActivity,val genres : List<GenreVo>) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return genres.size
    }

    override fun createFragment(position: Int): Fragment {
        return GenreListFragment.newInstance(genres[position].id)
    }


}