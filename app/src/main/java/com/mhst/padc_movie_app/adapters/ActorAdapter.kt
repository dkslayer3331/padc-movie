package com.mhst.padc_movie_app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mhst.padc_movie_app.R
import com.mhst.padc_movie_app.adapters.BaseRecyclerAdapter
import com.mhst.padc_movie_app.data.vos.PersonVO
import com.mhst.padc_movie_app.delegate.FavDelegate
import com.mhst.padc_movie_app.views.viewholders.ActorViewholder

/**
 * Created by Moe Htet on 31,July,2020
 */
class ActorAdapter(val favDelegate: FavDelegate) : BaseRecyclerAdapter<ActorViewholder, PersonVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.actor_viewpod,parent,false)
        return ActorViewholder(view,favDelegate)
    }
}