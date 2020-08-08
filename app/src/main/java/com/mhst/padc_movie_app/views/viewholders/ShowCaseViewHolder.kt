package com.mhst.padc_movie_app.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.mhst.padc_movie_app.data.vos.MovieVO
import com.mhst.padc_movie_app.delegate.TapVideo
import com.mhst.padc_movie_app.utils.next_lvl_url
import com.mhst.shared.BaseViewHolder
import kotlinx.android.synthetic.main.showcase_viewholder.view.*

/**
 * Created by Moe Htet on 02,August,2020
 */
class ShowCaseViewHolder(val itemView: View,val delegate: TapVideo) : BaseViewHolder<MovieVO>(itemView) {

    init {
        itemView.setOnClickListener {
            delegate.navigateVideo(mData?.id?.toInt() ?: 0)
        }
    }

    override fun bindData(data: MovieVO) {
        mData = data
        Glide.with(itemView.context).load(next_lvl_url+data.posterPath).into(itemView.ivShowcase)
//        itemView.btnPlayShowcase.setOnClickListener {
//            delegate.navigateVideo(mData?.id?.toInt() ?: 0)
//        }
    }
}