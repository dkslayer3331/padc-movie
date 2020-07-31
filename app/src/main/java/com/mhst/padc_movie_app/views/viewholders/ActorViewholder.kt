package com.mhst.padc_movie_app.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.mhst.padc_movie_app.data.vos.PersonVO
import com.mhst.padc_movie_app.utils.POSTER_BASE_URL
import com.mhst.padc_movie_app.utils.next_lvl_url
import kotlinx.android.synthetic.main.actor_viewpod.view.*

/**
 * Created by Moe Htet on 31,July,2020
 */
class ActorViewholder(itemView: View) : BaseViewHolder<PersonVO>(itemView) {
    override fun bindData(data: PersonVO) {
        Glide.with(itemView.context).load("$next_lvl_url${data.profilePath}").into(itemView.ivActor)
        itemView.tvActorName.text = data.name
    }
}