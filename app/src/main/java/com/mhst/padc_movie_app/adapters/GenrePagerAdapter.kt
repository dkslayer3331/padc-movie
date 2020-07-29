package com.mhst.padc_movie_app.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * Created by Moe Htet on 29,July,2020
 */
class GenrePagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    var list : MutableList<String>? = null

    fun setGenreList(list : List<String>){

    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    override fun createFragment(position: Int): Fragment {
        TODO("Not yet implemented")
    }


}