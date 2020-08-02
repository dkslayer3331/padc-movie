package com.mhst.padc_movie_app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mhst.padc_movie_app.R
import com.mhst.padc_movie_app.data.vos.MovieVO
import com.mhst.padc_movie_app.delegate.TapDelegate
import com.mhst.padc_movie_app.delegate.TapVideo
import com.mhst.padc_movie_app.views.viewholders.ShowCaseViewHolder

/**
 * Created by Moe Htet on 02,August,2020
 */
class ShowcaseAdapter(val delegate: TapVideo) : BaseRecyclerAdapter<ShowCaseViewHolder, MovieVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowCaseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.showcase_viewholder,parent,false)
        return ShowCaseViewHolder(view,delegate)
    }
}