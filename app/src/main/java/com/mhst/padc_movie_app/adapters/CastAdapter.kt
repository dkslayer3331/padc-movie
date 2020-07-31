package com.mhst.padc_movie_app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mhst.padc_movie_app.R
import com.mhst.padc_movie_app.adapters.BaseRecyclerAdapter
import com.mhst.padc_movie_app.data.vos.CastVO
import com.mhst.padc_movie_app.views.viewholders.CastViewHolder

/**
 * Created by Moe Htet on 01,August,2020
 */
class CastAdapter : BaseRecyclerAdapter<CastViewHolder, CastVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.actor_viewpod,parent,false)
        return CastViewHolder(view)
    }
}