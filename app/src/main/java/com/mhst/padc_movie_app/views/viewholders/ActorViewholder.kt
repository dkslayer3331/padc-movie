package com.mhst.padc_movie_app.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.mhst.padc_movie_app.R
import com.mhst.padc_movie_app.data.vos.PersonVO
import com.mhst.padc_movie_app.delegate.FavDelegate
import com.mhst.padc_movie_app.utils.next_lvl_url
import com.mhst.shared.BaseViewHolder
import kotlinx.android.synthetic.main.actor_viewpod.view.*

/**
 * Created by Moe Htet on 31,July,2020
 */
class ActorViewholder(val itemView: View,val favDelegate: FavDelegate) : BaseViewHolder<PersonVO>(itemView) {
    override fun bindData(data: PersonVO) {
        Glide.with(itemView.context).load("$next_lvl_url${data.profilePath}")
            .error(R.drawable.avatar_placeholder)
            .into(itemView.ivActor)
        itemView.tvActorName.text = data.name
        itemView.ivFav.setImageResource(if(data.isFav) R.drawable.ic_baseline_favorite_24 else R.drawable.ic_baseline_favorite_border_24)
        itemView.ivFav.setOnClickListener {
            favDelegate.onTapFav(data.id,!data.isFav)
        }
    }
}