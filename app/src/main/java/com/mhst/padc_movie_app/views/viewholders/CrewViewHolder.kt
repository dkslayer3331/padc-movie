package com.mhst.padc_movie_app.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.mhst.padc_movie_app.data.vos.CrewVO
import com.mhst.padc_movie_app.utils.next_lvl_url
import kotlinx.android.synthetic.main.actor_viewpod.view.*

/**
 * Created by Moe Htet on 01,August,2020
 */
class CrewViewHolder(itemView: View) : BaseViewHolder<CrewVO>(itemView) {
    override fun bindData(data: CrewVO) {
        Glide.with(itemView.context).load("$next_lvl_url${data.profilePath}").into(itemView.ivActor)
        itemView.tvActorName.text = data.name
    }
}