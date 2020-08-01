package com.mhst.padc_movie_app.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.mhst.padc_movie_app.adapters.ImageSliderAdapter
import kotlinx.android.synthetic.main.viwepod_slidere.view.*

/**
 * Created by Moe Htet on 01,August,2020
 */
class ImageSliderViewpod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    fun binData(imageSliderAdapter: ImageSliderAdapter){
                vpImageSlider.adapter = imageSliderAdapter
        TabLayoutMediator(tabForIndicator, vpImageSlider) { tab, position ->
        }.attach()
    }

}