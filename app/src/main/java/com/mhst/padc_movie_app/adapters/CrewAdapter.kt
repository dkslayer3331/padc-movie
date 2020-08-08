package com.mhst.padc_movie_app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mhst.padc_movie_app.R
import com.mhst.shared.BaseRecyclerAdapter
import com.mhst.padc_movie_app.data.vos.CrewVO
import com.mhst.padc_movie_app.views.viewholders.CrewViewHolder

/**
 * Created by Moe Htet on 01,August,2020
 */
class CrewAdapter : BaseRecyclerAdapter<CrewViewHolder, CrewVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.actor_viewpod,parent,false)
        return CrewViewHolder(view)
    }
}