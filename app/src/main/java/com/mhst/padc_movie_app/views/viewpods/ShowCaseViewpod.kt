package com.mhst.padc_movie_app.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.mhst.padc_movie_app.adapters.ShowcaseAdapter
import com.mhst.padc_movie_app.data.vos.MovieVO
import com.mhst.padc_movie_app.views.viewholders.ShowCaseViewHolder
import kotlinx.android.synthetic.main.showcase_viwepod.view.*

/**
 * Created by Moe Htet on 02,August,2020
 */
class ShowCaseViewpod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    fun bindData(adapter : ShowcaseAdapter,movies : List<MovieVO>){
        rvShowcases.adapter = adapter
        adapter.setNewData(movies.toMutableList())
    }

}