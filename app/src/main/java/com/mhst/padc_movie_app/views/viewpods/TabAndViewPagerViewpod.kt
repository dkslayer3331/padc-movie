package com.mhst.padc_movie_app.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.widget.LinearLayout
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.mhst.padc_movie_app.adapters.GenrePagerAdapter
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.viewpod_tab_and_viewpager.view.*

/**
 * Created by Moe Htet on 01,August,2020
 */
class TabAndViewPagerViewpod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    fun bindData(genrePagerAdapter: GenrePagerAdapter){
        tabLayout.removeAllTabs()

        genreViewPager.adapter = genrePagerAdapter
        genreViewPager.currentItem = 0

        TabLayoutMediator(tabLayout,genreViewPager){ tab, position ->
            tab.text = genrePagerAdapter.genres[position].name
        }.attach()

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {}

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabSelected(tab: TabLayout.Tab?) {
                genreViewPager.currentItem = tab!!.position
                Log.d("currentTab",genreViewPager.currentItem.toString())
            }

        })
    }

}